package org.webtree.social.stackexchange.api.impl.integration;

import org.junit.jupiter.api.Test;
import org.webtree.social.stackexchange.domain.NetworkUser;
import org.webtree.social.stackexchange.domain.User;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by Udjin Skobelev on 06.10.2018.
 */

public class UserTemplateIntegrationTest extends AbstractStackObjectFetcherIntegrationTest {
    private static String SITE_API_NAME = "stackoverflow";

    @Test
    public void shouldReturnUserAssociatedAccounts() {
        List<NetworkUser> users = stackExchange.userOperations().getUserAssociatedAccounts();
        assertThat(users).isNotEmpty();
        assertThat(users.get(0).getSiteName()).isNotEmpty();
        assertThat(users.get(0).getAccountId()).isNotNull().isPositive();
    }

    @Test
    public void shouldReturnUserBySiteName() {
        List<User> users = stackExchange.userOperations().getUserProfileAssociatedWithSite(SITE_API_NAME);
        assertThat(users).isNotEmpty();
        assertThat(users.get(0).getReputation()).isNotNull().isPositive();
        assertThat(users.get(0).getAccountId()).isNotNull().isPositive();
        assertThat(users.get(0).getDisplayName()).isNotEmpty();
    }
}
