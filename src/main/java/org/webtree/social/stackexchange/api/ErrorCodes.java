package org.webtree.social.stackexchange.api;

/**
 * Created by Udjin Skobelev on 02.10.2018.
 */

public class ErrorCodes {
    public static final int UNKNOWN_ERROR = 0;
    public static final int BAD_PARAMETER = 400;
    public static final int ACCESS_TOKEN_REQUIRED = 401;
    public static final int INVALID_ACCESS_TOKEN = 402;
    public static final int ACCESS_DENIED = 403;
    public static final int NO_METHOD = 404;
    public static final int KEY_REQUIRED = 405;
    public static final int ACCESS_TOKEN_COMPROMISED = 406;
    public static final int WRITE_FAILED = 407;
    public static final int DUPLICATE_REQUEST = 409;
    public static final int INTERNAL_ERROR = 500;
    public static final int THROTTLE_VIOLATION = 501;
    public static final int EMPORARITY_UNAVAILABLE = 502;
}
