package org.webtree.social.stackexchange.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import org.springframework.http.HttpStatus;
import org.springframework.mock.http.client.MockClientHttpResponse;
import org.springframework.social.*;
import org.webtree.social.stackexchange.api.Errors;
import org.webtree.social.stackexchange.api.StackExchangeError;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.webtree.social.stackexchange.api.ErrorCodes.*;


/**
 * Created by Udjin Skobelev on 05.10.2018.
 */

public class StackExchangeErrorHandlerTest {
    private static String MESSAGE = "test message";
    private static String ERROR_NAME = "some error name";

    private StackExchangeErrorHandler errorHandler;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() throws Exception {
        errorHandler = new StackExchangeErrorHandler();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void shouldExtractErrorFromResponseAndThrowAppropriateException() throws IOException {
        StackExchangeError badParameterError = new StackExchangeError(BAD_PARAMETER, MESSAGE, ERROR_NAME);
        String json = objectMapper.writeValueAsString(badParameterError);
        MockClientHttpResponse response = new MockClientHttpResponse(json.getBytes(), HttpStatus.BAD_REQUEST);
        assertThrows(UncategorizedApiException.class, () -> errorHandler.handleError(response));
    }

    @ParameterizedTest
    @EnumSource(Errors.class)
    public void shouldThrowExpectedException(Errors errors) {
        StackExchangeError badParameterError = new StackExchangeError(errors.getErrorCode(), MESSAGE, ERROR_NAME);
        assertThrows(errors.getExceptionClass(), () -> errorHandler.handleStackExchangeError(badParameterError));
    }
}

