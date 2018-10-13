package org.webtree.social.stackexchange.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.HttpStatus;
import org.springframework.mock.http.client.MockClientHttpResponse;
import org.springframework.social.*;

import org.webtree.social.stackexchange.api.StackExchangeError;

import java.io.IOException;
import java.util.stream.Stream;

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


    @ParameterizedTest(name = "\"{0}\" error code should thrown {1}")
    @MethodSource(value = "createErrorCodeAndExceptionPair")
    public void shouldThrowExpectedException(int errorCode, Class exceptionClass) {
        StackExchangeError badParameterError = new StackExchangeError(errorCode, MESSAGE, ERROR_NAME);
        assertThrows(exceptionClass, () -> errorHandler.handleStackExchangeError(badParameterError));
    }

    private static Stream<Arguments> createErrorCodeAndExceptionPair() {
        return Stream.of(
                Arguments.of(400, UncategorizedApiException.class),
                Arguments.of(401, MissingAuthorizationException.class),
                Arguments.of(402, InvalidAuthorizationException.class),
                Arguments.of(403, InsufficientPermissionException.class),
                Arguments.of(404, ResourceNotFoundException.class),
                Arguments.of(405, UncategorizedApiException.class),
                Arguments.of(406, UncategorizedApiException.class),
                Arguments.of(407, InternalServerErrorException.class),
                Arguments.of(409, UncategorizedApiException.class),
                Arguments.of(500, InternalServerErrorException.class),
                Arguments.of(501, RateLimitExceededException.class),
                Arguments.of(502, ServerException.class),
                Arguments.of(0, ApiException.class));
    }
}

