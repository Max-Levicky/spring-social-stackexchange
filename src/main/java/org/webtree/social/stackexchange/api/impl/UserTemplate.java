package org.webtree.social.stackexchange.api.impl;

import org.springframework.web.client.RestTemplate;
import org.webtree.social.stackexchange.api.*;

import java.util.List;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public class UserTemplate implements UserOperations {
    private final Api api;
    private final RestTemplate restTemplate;

    public UserTemplate(Api api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUserProfileAssociatedWithSite(String siteName) {
        return api.fetchObject("me?site=" + siteName, User.class).getItems();
    }

    @Override
    public List<NetworkUser> getUserAssociatedAccounts() {
        return api.fetchObject("me/associated", NetworkUser.class).getItems();
    }
}
