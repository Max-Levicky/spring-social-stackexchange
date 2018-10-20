package org.webtree.social.stackexchange.api.impl;

import org.webtree.social.stackexchange.api.NetworkUserOperations;
import org.webtree.social.stackexchange.api.StackObjectFetcher;
import org.webtree.social.stackexchange.domain.NetworkUser;

import java.util.List;

/**
 * Created by Udjin Skobelev on 20.10.2018.
 */
public class NetworkUserTemplate implements NetworkUserOperations {
    private StackObjectFetcher<NetworkUser> stackObjectFetcher;

    public NetworkUserTemplate(StackObjectFetcher<NetworkUser> stackObjectFetcher) {
        this.stackObjectFetcher = stackObjectFetcher;
    }

    @Override
    public List<NetworkUser> getUserAssociatedAccounts() {
        return stackObjectFetcher.fetch("me/associated").getItems();
    }
}
