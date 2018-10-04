package org.webtree.social.stackexchange.api.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.*;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.webtree.social.stackexchange.api.StackExchangeError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import static org.webtree.social.stackexchange.api.StackExchangeErrors.*;

/**
 * Created by Udjin Skobelev on 29.09.2018.
 */

public class StackExchangeErrorHandler extends DefaultResponseErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(StackExchangeErrorHandler.class);
    private static final String STACK_EXCHANGE_PROVIDER_ID = "stackExchange";

    StackExchangeErrorHandler() {
    }

    public void handleError(ClientHttpResponse response) throws IOException {
        StackExchangeError error = this.extractErrorFromResponse(response);
        handleStackExchangeError(response.getStatusCode(), error);
    }

    void handleStackExchangeError(HttpStatus statusCode, StackExchangeError error) {
        if (error != null && error.getCode() != null) {
            int code = error.getCode();
            switch (code) {
                case BAD_PARAMETER:
                    throw new UncategorizedApiException(STACK_EXCHANGE_PROVIDER_ID, error.getMessage(), null);
                case ACCESS_TOKEN_REQUIRED:
                    throw new MissingAuthorizationException(STACK_EXCHANGE_PROVIDER_ID);
                case INVALID_ACCESS_TOKEN:
                    throw new InvalidAuthorizationException(STACK_EXCHANGE_PROVIDER_ID, error.getMessage());
                case ACCESS_DENIED:
                    throw new InsufficientPermissionException(STACK_EXCHANGE_PROVIDER_ID);
                case NO_METHOD:
                    throw new ResourceNotFoundException(STACK_EXCHANGE_PROVIDER_ID, error.getMessage());
                case KEY_REQUIRED:
                    throw new UncategorizedApiException(STACK_EXCHANGE_PROVIDER_ID, error.getMessage(), null);
                case ACCESS_TOKEN_COMPROMISED:
                    throw new UncategorizedApiException(STACK_EXCHANGE_PROVIDER_ID, error.getMessage(), null);
                case WRITE_FAILED:
                    throw new InternalServerErrorException(STACK_EXCHANGE_PROVIDER_ID, error.getMessage());
                case DUPLICATE_REQUEST:
                    throw new UncategorizedApiException(STACK_EXCHANGE_PROVIDER_ID, error.getMessage(), null);
                case INTERNAL_ERROR:
                    throw new InternalServerErrorException(STACK_EXCHANGE_PROVIDER_ID, error.getMessage());
                case THROTTLE_VIOLATION:
                    throw new RateLimitExceededException(STACK_EXCHANGE_PROVIDER_ID);
                case EMPORARITY_UNAVAILABLE:
                    throw new ServerException(STACK_EXCHANGE_PROVIDER_ID, error.getMessage());
                default:
                    throw new UncategorizedApiException(STACK_EXCHANGE_PROVIDER_ID, "Something goes wrong", null);
            }
        } else {
            throw new ServerException(STACK_EXCHANGE_PROVIDER_ID, " Error code is " + statusCode);
        }
    }

    private StackExchangeError extractErrorFromResponse(ClientHttpResponse response) throws IOException {
        String json = this.readResponseJson(response);
        try {
            ObjectMapper mapper = new ObjectMapper(new JsonFactory());
            JsonNode jsonNode = mapper.readValue(json, JsonNode.class);
            if (jsonNode.has("error_id")) {
                Integer code = jsonNode.get("error_id").intValue();
                String message = jsonNode.get("error_message").asText();
                String name = jsonNode.get("error_name").asText();
                StackExchangeError error = new StackExchangeError(code, message, name);

                logger.debug("StackExchange error: ");
                logger.debug("   CODE     : {}", jsonNode.get("error_id"));
                logger.debug("   MESSAGE  : {}", jsonNode.get("error_message"));
                logger.debug("   NAME     : {}", jsonNode.get("error_name"));

                return error;
            }

        } catch (JsonParseException var13) {
            return null;
        }
        return null;
    }

    private String readResponseJson(ClientHttpResponse response) throws IOException {
        String json = this.readFully(response.getBody());
        logger.debug("Error from StackExchange: {}", json);
        return json;
    }

    private String readFully(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append(reader.readLine());
        }
        return sb.toString();
    }
}
