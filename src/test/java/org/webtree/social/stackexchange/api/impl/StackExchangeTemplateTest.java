package org.webtree.social.stackexchange.api.impl;

import org.junit.Test;

import org.webtree.social.stackexchange.api.NetworkUser;
import org.webtree.social.stackexchange.api.StackExchange;

import java.util.List;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */
public class StackExchangeTemplateTest {

    @Test
    public void fetchObject() {
        StackExchange stackExchange = new StackExchangeTemplate("L88aHHHV6ZYJfyyyzs(zmA))", "kRqvE0TkIhi2jv6nw14VpA((");
        List<NetworkUser> list = stackExchange.userOperations().getUserAssociatedAccounts();
        list.toString();
    }
}