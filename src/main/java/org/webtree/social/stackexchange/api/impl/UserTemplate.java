package org.webtree.social.stackexchange.api.impl;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.webtree.social.stackexchange.api.*;
import org.webtree.social.stackexchange.domain.NetworkUser;
import org.webtree.social.stackexchange.domain.User;

import java.util.List;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public class UserTemplate implements UserOperations {
    private StackObjectFetcher stackObjectFetcher;

    public UserTemplate(StackObjectFetcher stackObjectFetcher) {
        this.stackObjectFetcher = stackObjectFetcher;
    }

    @Override
    public List<User> getUserProfileAssociatedWithSite(String siteName) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("site", siteName);
        return stackObjectFetcher.fetchObject("me", User.class, queryParams).getItems();
    }

    @Override
    public List<NetworkUser> getUserAssociatedAccounts() {
        return stackObjectFetcher.fetchObject("me/associated", NetworkUser.class).getItems();
    }
}
