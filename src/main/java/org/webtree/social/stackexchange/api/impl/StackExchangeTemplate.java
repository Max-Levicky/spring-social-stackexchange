package org.webtree.social.stackexchange.api.impl;

import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.ApiBinding;

import org.springframework.web.client.RestTemplate;
import org.webtree.social.stackexchange.api.*;
import org.webtree.social.stackexchange.domain.NetworkUser;
import org.webtree.social.stackexchange.domain.Site;
import org.webtree.social.stackexchange.domain.User;
import org.webtree.social.stackexchange.interceptor.BasicHttpRequestInterceptor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public class StackExchangeTemplate implements ApiBinding, StackExchange {
    private String accessToken;
    private String apiVersion = "2.2";
    private String baseApiUrl;
    private RestTemplate restTemplate;
    private UserOperations userOperations;
    private NetworkUserOperations networkUserOperations;
    private SiteOperations siteOperations;
    private StackObjectFetcher stackObjectFetcher;


    public StackExchangeTemplate(String accessToken, String key) {
        this.baseApiUrl = "https://stackObjectFetcher.stackexchange.com/" + apiVersion + "/";
        this.accessToken = accessToken;
        this.restTemplate = createRestTemplate(accessToken, key);
        this.stackObjectFetcher = new StackObjectFetcherImpl(baseApiUrl, restTemplate);
        initOperations();
    }

    public boolean isAuthorized() {
        return accessToken != null;
    }

    public UserOperations userOperations() {
        return userOperations;
    }

    public SiteOperations siteOperations() {
        return siteOperations;
    }

    public NetworkUserOperations networkUserOperations() { return networkUserOperations; }

    public String getBaseApiUrl() {
        return baseApiUrl;
    }

    RestTemplate getRestTemplate() {
        return restTemplate;
    }

    private FormHttpMessageConverter createFormMessageConverter() {
        FormHttpMessageConverter converter = new FormHttpMessageConverter();
        converter.setCharset(Charset.forName("UTF-8"));
        converter.setPartConverters(createPartConverters());
        return converter;
    }

    private List<HttpMessageConverter<?>> createPartConverters() {
        List<HttpMessageConverter<?>> partConverters = new ArrayList<>();
        partConverters.add(new ByteArrayHttpMessageConverter());
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        stringHttpMessageConverter.setWriteAcceptCharset(false);
        partConverters.add(stringHttpMessageConverter);
        partConverters.add(new ResourceHttpMessageConverter());
        return partConverters;
    }

    private MappingJackson2HttpMessageConverter createJsonMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    private RestTemplate createRestTemplate(String accessToken, String key) {
        RestTemplate client = createRestTemplateWithCulledMessageConverters();
        List<ClientHttpRequestInterceptor> interceptors = Arrays.asList(
                new BasicHttpRequestInterceptor("key", key),
                new BasicHttpRequestInterceptor("access_token", accessToken));
        client.setInterceptors(interceptors);
        client.setErrorHandler(new StackExchangeErrorHandler());
        client.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        return client;
    }

    private RestTemplate createRestTemplateWithCulledMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = getMessageConverters();
        return new RestTemplate(messageConverters);
    }

    private List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(createFormMessageConverter());
        messageConverters.add(createJsonMessageConverter());
        messageConverters.add(getByteArrayMessageConverter());
        return messageConverters;
    }

    private ByteArrayHttpMessageConverter getByteArrayMessageConverter() {
        ByteArrayHttpMessageConverter converter = new ByteArrayHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.IMAGE_JPEG, MediaType.IMAGE_GIF, MediaType.IMAGE_PNG));
        return converter;
    }

    private void initOperations() {
        this.userOperations = new UserTemplate(new StackObjectFetcherImpl<User>(getBaseApiUrl(),getRestTemplate()));
        this.siteOperations = new SiteTemplate(new StackObjectFetcherImpl<Site>(getBaseApiUrl(),getRestTemplate()));
        this.networkUserOperations = new NetworkUserTemplate(new StackObjectFetcherImpl<NetworkUser>(getBaseApiUrl(),getRestTemplate()));
    }
}