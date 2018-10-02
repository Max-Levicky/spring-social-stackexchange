package org.webtree.social.stackexchange.api;

/**
 * Created by Udjin Skobelev on 02.10.2018.
 */

public class StackExchangeError {

    private Integer code;

    private String message;

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
