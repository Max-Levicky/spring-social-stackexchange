package org.webtree.social.stackexchange.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;
import org.springframework.http.HttpStatus;
import org.springframework.mock.http.client.MockClientHttpResponse;
import org.springframework.social.*;
import org.webtree.social.stackexchange.api.StackExchangeError;

import java.io.IOException;

import static org.webtree.social.stackexchange.api.StackExchangeErrors.*;


/**
 * Created by Udjin Skobelev on 05.10.2018.
 */

public class StackExchangeErrorHandlerTest {
    private static String MESSAGE = "test message";
    private static String ERROR_NAME = "some error name";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private StackExchangeErrorHandler errorHandler;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        errorHandler = new StackExchangeErrorHandler();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void shouldExtractErrorFromResponseAndThrowAppropriateException() throws IOException {
        StackExchangeError badParameterError = new StackExchangeError(BAD_PARAMETER, MESSAGE, ERROR_NAME);
        String json = objectMapper.writeValueAsString(badParameterError);
        MockClientHttpResponse response = new MockClientHttpResponse(json.getBytes(), HttpStatus.BAD_REQUEST);
        exception.expect(UncategorizedApiException.class);
        errorHandler.handleError(response);
    }

    //handleStackExchangeError tests

    @Test(expected = ServerException.class)
    public void shouldThrowExceptionIfErrorObjectIsNull() {
        StackExchangeError error = null;
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, error);
    }

    @Test(expected = ServerException.class)
    public void shouldThrowExceptionIfErrorCodeIsNull() {
        StackExchangeError error = new StackExchangeError(null, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, error);
    }

    @Test(expected = UncategorizedApiException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs400() {
        StackExchangeError badParameterError = new StackExchangeError(BAD_PARAMETER, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, badParameterError);
    }

    @Test(expected = MissingAuthorizationException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs401() {
        StackExchangeError accessTokenRequired = new StackExchangeError(ACCESS_TOKEN_REQUIRED, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, accessTokenRequired);
    }

    @Test(expected = InvalidAuthorizationException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs402() {
        StackExchangeError invalidAccessTokenError = new StackExchangeError(INVALID_ACCESS_TOKEN, MESSAGE, ERROR_NAME);

        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, invalidAccessTokenError);
    }

    @Test(expected = InsufficientPermissionException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs403() {
        StackExchangeError accessDeniedError = new StackExchangeError(ACCESS_DENIED, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, accessDeniedError);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs404() {
        StackExchangeError noMethodError = new StackExchangeError(NO_METHOD, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, noMethodError);
    }

    @Test(expected = UncategorizedApiException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs405() {
        StackExchangeError keyRequiredError = new StackExchangeError(KEY_REQUIRED, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, keyRequiredError);
    }

    @Test(expected = UncategorizedApiException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs406() {
        StackExchangeError accessTokenCompromisedError = new StackExchangeError(ACCESS_TOKEN_COMPROMISED, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, accessTokenCompromisedError);
    }

    @Test(expected = InternalServerErrorException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs407() {
        StackExchangeError writeFailedError = new StackExchangeError(WRITE_FAILED, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, writeFailedError);
    }

    @Test(expected = UncategorizedApiException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs409() {
        StackExchangeError duplicateRequestError = new StackExchangeError(DUPLICATE_REQUEST, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, duplicateRequestError);
    }

    @Test(expected = InternalServerErrorException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs500() {
        StackExchangeError internalErrorError = new StackExchangeError(INTERNAL_ERROR, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, internalErrorError);
    }

    @Test(expected = RateLimitExceededException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs501() {
        StackExchangeError throttleViolationError = new StackExchangeError(THROTTLE_VIOLATION, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, throttleViolationError);
    }

    @Test(expected = ServerException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIs502() {
        StackExchangeError emporarityUnavailableError = new StackExchangeError(EMPORARITY_UNAVAILABLE, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, emporarityUnavailableError);
    }

    @Test(expected = UncategorizedApiException.class)
    public void shouldThrowExpectedExceptionIfErrorCodeIsUnknown() {
        //default case
        StackExchangeError defaultError = new StackExchangeError(1, MESSAGE, ERROR_NAME);
        errorHandler.handleStackExchangeError(HttpStatus.BAD_REQUEST, defaultError);
    }
}

