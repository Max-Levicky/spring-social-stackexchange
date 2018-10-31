package org.webtree.social.stackexchange.api.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.*;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.webtree.social.stackexchange.api.ErrorHandler;

import org.webtree.social.stackexchange.api.StackExchangeError;

import java.io.IOException;
import java.util.Map;

import static java.net.HttpURLConnection.*;

/**
 * Created by Udjin Skobelev on 29.09.2018.
 */

public class StackExchangeErrorHandler extends DefaultResponseErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(StackExchangeErrorHandler.class);
    private static final String PROVIDER_ID = "stackExchange";
    private Map<Integer, ErrorHandler> handlers = ImmutableMap.<Integer, ErrorHandler>builder()

            .put(HTTP_BAD_REQUEST, (error) -> {
                throw new UncategorizedApiException(PROVIDER_ID, error.getErrorMessage(), null);
            })
            .put(HTTP_UNAUTHORIZED, (error) -> {
                throw new MissingAuthorizationException(PROVIDER_ID);
            })
            .put(HTTP_PAYMENT_REQUIRED, (error) -> {
                throw new InvalidAuthorizationException(PROVIDER_ID, error.getErrorMessage());
            })
            .put(HTTP_FORBIDDEN, (error) -> {
                throw new InsufficientPermissionException(PROVIDER_ID);
            })
            .put(HTTP_NOT_FOUND, (error) -> {
                throw new ResourceNotFoundException(PROVIDER_ID, error.getErrorMessage());
            })
            .put(HTTP_BAD_METHOD, (error) -> {
                throw new UncategorizedApiException(PROVIDER_ID, error.getErrorMessage(), null);
            })
            .put(HTTP_NOT_ACCEPTABLE, (error) -> {
                throw new UncategorizedApiException(PROVIDER_ID, error.getErrorMessage(), null);
            })
            .put(HTTP_PROXY_AUTH, (error) -> {
                throw new InternalServerErrorException(PROVIDER_ID, error.getErrorMessage());
            })
            .put(HTTP_CONFLICT, (error) -> {
                throw new UncategorizedApiException(PROVIDER_ID, error.getErrorMessage(), null);
            })
            .put(HTTP_INTERNAL_ERROR, (error) -> {
                throw new InternalServerErrorException(PROVIDER_ID, error.getErrorMessage());
            })
            .put(HTTP_NOT_IMPLEMENTED, (error) -> {
                throw new RateLimitExceededException(PROVIDER_ID);
            })
            .put(HTTP_BAD_GATEWAY, (error) -> {
                throw new ServerException(PROVIDER_ID, error.getErrorMessage());
            }).build();

    StackExchangeErrorHandler() {
    }

    public void handleError(ClientHttpResponse response) throws IOException {
        StackExchangeError error = extractErrorFromResponse(response);
        handleStackExchangeError(error);
    }

    void handleStackExchangeError(StackExchangeError error) {
        handlers.getOrDefault(error.getErrorId(), (defaultError) -> {
            throw new ApiException(PROVIDER_ID, defaultError.getErrorMessage());
        }).handle(error);
    }

    private StackExchangeError extractErrorFromResponse(ClientHttpResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            StackExchangeError error = mapper.readValue(response.getBody(), StackExchangeError.class);

            logger.debug("StackExchange error: ");
            logger.debug("   CODE     : {}", error.getErrorId());
            logger.debug("   MESSAGE  : {}", error.getErrorMessage());
            logger.debug("   NAME     : {}", error.getErrorName());

            return error;
        } catch (JsonProcessingException exception) {
            throw new ApiException(PROVIDER_ID, "Cannot process response json body", exception);
        }
    }
}