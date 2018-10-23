package org.webtree.social.stackexchange.api.impl;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.webtree.social.stackexchange.domain.ResponseWrapper;
import org.webtree.social.stackexchange.domain.User;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by Udjin Skobelev on 06.10.2018.
 */

public class UserTemplateTest extends AbstractStackObjectFetcherTest {
    private final static String SITE_API_NAME = "stackexchange";

    @Test
    public void shouldReturnUserBySiteNameIfExists() throws JsonProcessingException {
        User user = new User(3, 4, "John");
       List<User> users = Arrays.asList(user);

       responseWrapper = new ResponseWrapper<>(users, true, 1, 2);

        server
                .expect(requestTo(baseApiUrl + "me?site=" + SITE_API_NAME + "&" + tokenQueryParams))
                .andRespond(withSuccess(objectMapper.writeValueAsString(responseWrapper), MediaType.APPLICATION_JSON));

        Optional<User> usersFromApi = stackExchange.userOperations().getUserProfileBySiteName(SITE_API_NAME);
        assertThat(usersFromApi.isPresent()).isTrue();
    }

    @Test
    public void shouldReturnEmpty() throws JsonProcessingException {
        List<User> users = Collections.emptyList();

        responseWrapper = new ResponseWrapper<>(users, true, 1, 2);

        server
                .expect(requestTo(baseApiUrl + "me?site=" + SITE_API_NAME + "&" + tokenQueryParams))
                .andRespond(withSuccess(objectMapper.writeValueAsString(responseWrapper), MediaType.APPLICATION_JSON));

        Optional<User> usersFromApi = stackExchange.userOperations().getUserProfileBySiteName(SITE_API_NAME);
        assertThat(usersFromApi.isPresent()).isFalse();
    }
}