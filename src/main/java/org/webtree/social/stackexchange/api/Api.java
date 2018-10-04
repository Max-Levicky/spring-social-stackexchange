package org.webtree.social.stackexchange.api;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public interface Api {
    <T> ResponseWrapper<T> fetchObject(String methodName, Class<T> itemsType);
    String getBaseApiUrl();
}
