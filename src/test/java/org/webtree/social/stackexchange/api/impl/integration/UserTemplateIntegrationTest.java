package org.webtree.social.stackexchange.api.impl.integration;

import org.junit.Test;
import org.webtree.social.stackexchange.domain.NetworkUser;
import org.webtree.social.stackexchange.domain.User;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by Udjin Skobelev on 06.10.2018.
 */

public class UserTemplateIntegrationTest extends AbstractApiIntegrationTest {
    private static String SITE_API_NAME = "stackoverflow";

    @Test
    public void shouldReturnUserAssociatedAccounts() {
        List<NetworkUser> users = stackExchange.userOperations().getUserAssociatedAccounts();
        assertThat(users).isNotEmpty();
        }

    @Test
    public void shouldReturnUserBySiteName() {
        List<User> users = stackExchange.userOperations().getUserProfileAssociatedWithSite(SITE_API_NAME);
        assertThat(users).isNotEmpty();
    }
}
