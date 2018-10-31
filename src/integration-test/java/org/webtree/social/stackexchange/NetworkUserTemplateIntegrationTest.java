package org.webtree.social.stackexchange;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.webtree.social.stackexchange.domain.NetworkUser;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by Udjin Skobelev on 20.10.2018.
 */
public class NetworkUserTemplateIntegrationTest extends AbstractStackObjectFetcherIntegrationTest {
    @Test
    public void shouldReturnUserAssociatedAccounts() {
        List<NetworkUser> users = stackExchange.networkUserOperations().getUserAssociatedAccounts();
        assertThat(users).isNotEmpty();
        AssertionsForClassTypes.assertThat(users.get(0).getSiteName()).isNotEmpty();
        AssertionsForClassTypes.assertThat(users.get(0).getAccountId()).isNotNull().isPositive();
    }
}
