package org.webtree.social.stackexchange.api.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.ApiBinding;
import org.springframework.social.support.URIBuilder;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.webtree.social.stackexchange.api.*;
import org.webtree.social.stackexchange.domain.ResponseWrapper;
import org.webtree.social.stackexchange.interceptor.BasicHttpRequestInterceptor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;


/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public class StackExchangeTemplate implements ApiBinding, StackExchange {

    private final String accessToken;
    private String apiVersion = "2.2";
    private RestTemplate restTemplate;
    private UserOperations userOperations;
    private SiteOperations siteOperations;


    public StackExchangeTemplate(String accessToken, String key) {
        this.accessToken = accessToken;
        this.restTemplate = createRestTemplate(accessToken, key);
        setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        initSubApis();
    }

    public boolean isAuthorized() {
        return accessToken != null;
    }

    public <T> ResponseWrapper<T> fetchObject(String method, Class<T> type) {
        URI uri = URIBuilder.fromUri(getBaseApiUrl() + method).build();
        return getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseWrapper<T>>() {
            public Type getType() {
                return new ParameterizedTypeImpl((ParameterizedType) super.getType(), new Type[]{type});
            }
        }).getBody();
    }

    @Override
    public <T> ResponseWrapper<T> fetchObject(String methodName, Class<T> itemsType, MultiValueMap<String, String> queryParams) {
        URI uri = URIBuilder.fromUri(getBaseApiUrl() + methodName).queryParams(queryParams).build();
        return getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseWrapper<T>>() {
            public Type getType() {
                return new ParameterizedTypeImpl((ParameterizedType) super.getType(), new Type[]{itemsType});
            }
        }).getBody();
    }

    public UserOperations userOperations() {
        return userOperations;
    }

    public SiteOperations siteOperations() {
        return siteOperations;
    }

    public String getBaseApiUrl() {
        return "https://api.stackexchange.com/" + apiVersion + "/";
    }

    RestTemplate getRestTemplate() {
        return restTemplate;
    }

    private FormHttpMessageConverter getFormMessageConverter() {
        FormHttpMessageConverter converter = new FormHttpMessageConverter();
        converter.setCharset(Charset.forName("UTF-8"));
        List<HttpMessageConverter<?>> partConverters = new ArrayList();
        partConverters.add(new ByteArrayHttpMessageConverter());
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        stringHttpMessageConverter.setWriteAcceptCharset(false);
        partConverters.add(stringHttpMessageConverter);
        partConverters.add(new ResourceHttpMessageConverter());
        converter.setPartConverters(partConverters);
        return converter;
    }

    private MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    private RestTemplate createRestTemplate(String accessToken, String key) {
        RestTemplate client = createRestTemplateWithCulledMessageConverters();
        List<ClientHttpRequestInterceptor> interceptors = Arrays.asList(
                new BasicHttpRequestInterceptor("key", key),
                new BasicHttpRequestInterceptor("access_token", accessToken));
        client.setInterceptors(interceptors);
        client.setErrorHandler(new StackExchangeErrorHandler());
        return client;
    }

    private RestTemplate createRestTemplateWithCulledMessageConverters() {
        List messageConverters = getMessageConverters();
        RestTemplate client = new RestTemplate(messageConverters);
        return client;
    }

    private List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList();
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(getFormMessageConverter());
        messageConverters.add(getJsonMessageConverter());
        messageConverters.add(getByteArrayMessageConverter());
        return messageConverters;
    }

    private ByteArrayHttpMessageConverter getByteArrayMessageConverter() {
        ByteArrayHttpMessageConverter converter = new ByteArrayHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.IMAGE_JPEG, MediaType.IMAGE_GIF, MediaType.IMAGE_PNG));
        return converter;
    }

    private void setRequestFactory(ClientHttpRequestFactory requestFactory) {
        restTemplate.setRequestFactory(requestFactory);
    }

    private void initSubApis() {
        this.userOperations = new UserTemplate(this, getRestTemplate());
        this.siteOperations = new SiteTemplate(this, getRestTemplate());
    }
}