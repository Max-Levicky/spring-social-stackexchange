package org.webtree.social.stackexchange.api.impl;

import com.fasterxml.jackson.core.JsonParseException;
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

import static org.webtree.social.stackexchange.api.ErrorCodes.*;

/**
 * Created by Udjin Skobelev on 29.09.2018.
 */

public class StackExchangeErrorHandler extends DefaultResponseErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(StackExchangeErrorHandler.class);
    private static final String STACK_EXCHANGE_PROVIDER_ID = "stackExchange";
    private Map<Integer, ErrorHandler> handlers = ImmutableMap.<Integer, ErrorHandler>builder()

            .put(BAD_PARAMETER, (error) -> {
                throw new UncategorizedApiException(STACK_EXCHANGE_PROVIDER_ID, error.getErrorMessage(), null);
            })
            .put(ACCESS_TOKEN_REQUIRED, (error) -> {
                throw new MissingAuthorizationException(STACK_EXCHANGE_PROVIDER_ID);
            })
            .put(INVALID_ACCESS_TOKEN, (error) -> {
                throw new InvalidAuthorizationException(STACK_EXCHANGE_PROVIDER_ID, error.getErrorMessage());
            })
            .put(ACCESS_DENIED, (error) -> {
                throw new InsufficientPermissionException(STACK_EXCHANGE_PROVIDER_ID);
            })
            .put(NO_METHOD, (error) -> {
                throw new ResourceNotFoundException(STACK_EXCHANGE_PROVIDER_ID, error.getErrorMessage());
            })
            .put(KEY_REQUIRED, (error) -> {
                throw new UncategorizedApiException(STACK_EXCHANGE_PROVIDER_ID, error.getErrorMessage(), null);
            })
            .put(ACCESS_TOKEN_COMPROMISED, (error) -> {
                throw new UncategorizedApiException(STACK_EXCHANGE_PROVIDER_ID, error.getErrorMessage(), null);
            })
            .put(WRITE_FAILED, (error) -> {
                throw new InternalServerErrorException(STACK_EXCHANGE_PROVIDER_ID, error.getErrorMessage());
            })
            .put(DUPLICATE_REQUEST, (error) -> {
                throw new UncategorizedApiException(STACK_EXCHANGE_PROVIDER_ID, error.getErrorMessage(), null);
            })
            .put(INTERNAL_ERROR, (error) -> {
                throw new InternalServerErrorException(STACK_EXCHANGE_PROVIDER_ID, error.getErrorMessage());
            })
            .put(THROTTLE_VIOLATION, (error) -> {
                throw new RateLimitExceededException(STACK_EXCHANGE_PROVIDER_ID);
            })
            .put(EMPORARITY_UNAVAILABLE, (error) -> {
                throw new ServerException(STACK_EXCHANGE_PROVIDER_ID, error.getErrorMessage());
            })
            .put(UNKNOWN_ERROR, (error) -> {
                throw new ApiException(STACK_EXCHANGE_PROVIDER_ID, error.getErrorMessage());
            }).build();

    StackExchangeErrorHandler() {
    }

    public void handleError(ClientHttpResponse response) throws IOException {
        StackExchangeError error = extractErrorFromResponse(response);
        handleStackExchangeError(error);
    }

    void handleStackExchangeError(StackExchangeError error) {
        handlers.get(error.getErrorId()).handle(error);
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
        } catch (JsonParseException exception) {
            return new StackExchangeError(0, "Something goes wrong", null);
        }
    }
}






