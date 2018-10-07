package org.webtree.social.stackexchange.api;

import org.springframework.util.MultiValueMap;
import org.webtree.social.stackexchange.domain.ResponseWrapper;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public interface Api {
    <T> ResponseWrapper<T> fetchObject(String methodName, Class<T> itemsType);
    <T> ResponseWrapper<T> fetchObject(String methodName, Class<T> itemsType, MultiValueMap<String,String> queryParams);
    String getBaseApiUrl();
}
