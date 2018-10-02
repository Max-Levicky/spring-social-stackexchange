package org.webtree.social.stackexchange.api;

import org.springframework.util.MultiValueMap;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public interface Api {
    <T> T fetchObject(String var1, Class<T> var2);
    <T> T fetchObject(String var1, Class<T> var2, String... var3);
    <T> T fetchObject(String var1, Class<T> var2, MultiValueMap<String, String> var3);
    String getBaseApiUrl();
}
