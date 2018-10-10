package org.webtree.social.stackexchange.api;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Created by Udjin Skobelev on 02.10.2018.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StackExchangeError {
    private Integer errorId;
    private String errorMessage;
    private String errorName;

    public StackExchangeError() {
    }

    public StackExchangeError(Integer errorId, String errorMessage, String errorName) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
        this.errorName = errorName;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorName() {
        return errorName;
    }
}
