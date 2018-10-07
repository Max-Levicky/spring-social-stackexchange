package org.webtree.social.stackexchange.api.impl.integration;

import org.junit.Before;
import org.webtree.social.stackexchange.api.StackExchange;
import org.webtree.social.stackexchange.api.impl.StackExchangeTemplate;

/**
 * Created by Udjin Skobelev on 06.10.2018.
 */

public abstract class AbstractApiIntegrationTest {
    protected static String TOKEN = "i76N6VsEFIVLuX6eo(SQHA))";
    protected static String APP_KEY = "kRqvE0TkIhi2jv6nw14VpA((";
    protected StackExchange stackExchange;

    @Before
    public void setUp() throws Exception {
        stackExchange = new StackExchangeTemplate(TOKEN, APP_KEY);
    }
}
