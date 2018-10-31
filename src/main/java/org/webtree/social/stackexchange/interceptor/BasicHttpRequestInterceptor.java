package org.webtree.social.stackexchange.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.support.HttpRequestDecorator;

import java.io.IOException;

/**
 * Created by Udjin Skobelev on 30.09.2018.
 */

public class BasicHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    private String parameterName;
    private String parameterValue;

    public BasicHttpRequestInterceptor(String parameterName, String parameterValue) {
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpRequestDecorator protectedResourceRequest = new HttpRequestDecorator(request);
        protectedResourceRequest.addParameter(this.parameterName, this.parameterValue);
        return execution.execute(protectedResourceRequest, body);
    }
}
