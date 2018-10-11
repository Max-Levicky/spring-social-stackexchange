package org.webtree.social.stackexchange.api.impl.integration;


import org.junit.jupiter.api.BeforeEach;
import org.webtree.social.stackexchange.api.StackExchange;
import org.webtree.social.stackexchange.api.impl.StackExchangeTemplate;

/**
 * Created by Udjin Skobelev on 06.10.2018.
 */

public abstract class AbstractApiIntegrationTest {
    static String TOKEN;
    static String APP_KEY;
    StackExchange stackExchange;

    @BeforeEach
    public void setUp() throws Exception {
        TOKEN =  System.getenv("stackexchange_token");
        APP_KEY = System.getenv("stackexchange_key");
        stackExchange = new StackExchangeTemplate(TOKEN, APP_KEY);
    }
}
