package org.webtree.social.stackexchange.api.impl;

import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.webtree.social.stackexchange.api.BasicHttpRequestInterceptor;
import org.webtree.social.stackexchange.api.StackExchange;
import org.webtree.social.stackexchange.api.UserOperations;

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
    private final String apiVersion = "2.2";
    private RestTemplate restTemplate;
    private UserOperations userOperations;


    public StackExchangeTemplate(String accessToken, String key) {
        this.accessToken = accessToken;
        this.restTemplate = createRestTemplate(accessToken, key);
        setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//        setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
        initSubApis();
    }

    public boolean isAuthorized() {
        return accessToken != null;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }


    protected FormHttpMessageConverter getFormMessageConverter() {
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

    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
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

        RestTemplate client;
        try {
            client = new RestTemplate(messageConverters);
        } catch (NoSuchMethodError var4) {
            client = new RestTemplate();

            client.setMessageConverters(messageConverters);
        }

        client.setRequestFactory(ClientHttpRequestFactorySelector.getRequestFactory());
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
    }

    public <T> T fetchObject(String objectId, Class<T> type) {
        URI uri = URIBuilder.fromUri(this.getBaseApiUrl() + objectId).build();
        return this.getRestTemplate().getForObject(uri, type);
    }

    @Override
    public <T> T fetchObject(String var1, Class<T> var2, String... var3) {
        return null;
    }

    public <T> T fetchObject(String objectId, Class<T> type, MultiValueMap<String, String> queryParameters) {
        URI uri = URIBuilder.fromUri(this.getBaseApiUrl() + objectId).queryParams(queryParameters).build();
        return this.getRestTemplate().getForObject(uri, type);
    }

    public UserOperations userOperations() {
        return userOperations;
    }

    public String getBaseApiUrl() {
        return "https://api.stackexchange.com/" + apiVersion + "/";
    }
}