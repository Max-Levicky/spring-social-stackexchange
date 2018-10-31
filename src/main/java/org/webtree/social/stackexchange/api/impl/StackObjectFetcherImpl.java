package org.webtree.social.stackexchange.api.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.webtree.social.stackexchange.api.StackObjectFetcher;
import org.webtree.social.stackexchange.domain.ResponseWrapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;

/**
 * Created by Udjin Skobelev on 10.10.2018.
 */

public class StackObjectFetcherImpl implements StackObjectFetcher {
    private String apiUrl;
    private RestTemplate restTemplate;

    public StackObjectFetcherImpl(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> ResponseWrapper<T> fetch(String method, Class<T> type) {
        URI uri = URIBuilder.fromUri(apiUrl + method).build();
        return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseWrapper<T>>() {
            public Type getType() {
                return new ParameterizedTypeImpl((ParameterizedType) super.getType(), new Type[]{type});
            }
        }).getBody();
    }

    @Override
    public <T> ResponseWrapper<T> fetch(String methodName, Class<T> itemsType, MultiValueMap<String, String> queryParams) {
        URI uri = URIBuilder.fromUri(apiUrl + methodName).queryParams(queryParams).build();
        return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseWrapper<T>>() {
            public Type getType() {
                return new ParameterizedTypeImpl((ParameterizedType) super.getType(), new Type[]{itemsType});
            }
        }).getBody();
    }
}
