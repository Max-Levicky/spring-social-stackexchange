package org.webtree.social.stackexchange.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Udjin Skobelev on 02.10.2018.
 */

public class StackExchangeError {
    @JsonProperty("error_id")
    private Integer code;

    @JsonProperty("error_message")
    private String message;

    @JsonProperty("error_name")
    private String name;

    public StackExchangeError(Integer code, String message, String name) {
        this.code = code;
        this.message = message;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
}
