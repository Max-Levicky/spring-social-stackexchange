package org.webtree.social.stackexchange.api.impl.integration;

import org.junit.Before;
import org.webtree.social.stackexchange.api.StackExchange;
import org.webtree.social.stackexchange.api.impl.StackExchangeTemplate;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Udjin Skobelev on 06.10.2018.
 */

public abstract class AbstractApiIntegrationTest {
    static String TOKEN;
    static String APP_KEY;
    StackExchange stackExchange;

    @Before
    public void setUp() throws Exception {
        FileInputStream propFile = new FileInputStream("src/test/resources/system.property");
        Properties p = new Properties(System.getProperties());
        p.load(propFile);
        System.setProperties(p);
        TOKEN = System.getProperty("token");
        APP_KEY = System.getProperty("key");
        stackExchange = new StackExchangeTemplate(TOKEN, APP_KEY);
    }
}
