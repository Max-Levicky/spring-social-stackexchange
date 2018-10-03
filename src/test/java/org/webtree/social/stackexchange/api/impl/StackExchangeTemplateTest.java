package org.webtree.social.stackexchange.api.impl;

import org.junit.Test;

import org.webtree.social.stackexchange.api.NetworkUser;
import org.webtree.social.stackexchange.api.StackExchange;
import org.webtree.social.stackexchange.api.User;

import java.util.List;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public class StackExchangeTemplateTest {

    @Test
    public void fetchObject() {
        StackExchange stackExchange = new StackExchangeTemplate("nFybvP46LHGIbkXBBhB*jQ))", "kRqvE0TkIhi2jv6nw14VpA((");
        List<NetworkUser> list = stackExchange.userOperations().getUserAssociatedAccounts();
        List<User> list2 =  stackExchange.userOperations().getUserProfileAssociatedWithSite("stackoverflow");
        }
}