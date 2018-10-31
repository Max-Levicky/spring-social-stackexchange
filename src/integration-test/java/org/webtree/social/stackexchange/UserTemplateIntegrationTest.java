package org.webtree.social.stackexchange;

import org.apache.http.message.AbstractHttpMessage;
import org.junit.jupiter.api.Test;
import org.webtree.social.stackexchange.domain.User;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by Udjin Skobelev on 06.10.2018.
 */

public class UserTemplateIntegrationTest extends AbstractStackObjectFetcherIntegrationTest {
    private static String SITE_API_NAME = "stackoverflow";

    @Test
    public void shouldReturnUserBySiteName() {
        Optional<User> optionalUser = stackExchange.userOperations().getUserProfileBySiteName(SITE_API_NAME);
        assertThat(optionalUser.isPresent()).isTrue();
        assertThat(optionalUser.get().getReputation()).isNotNull().isPositive();
        assertThat(optionalUser.get().getAccountId()).isNotNull().isPositive();
        assertThat(optionalUser.get().getDisplayName()).isNotEmpty();
    }
}
