package org.webtree.social.stackexchange.api.impl;

import org.junit.Test;
import org.webtree.social.stackexchange.api.Site;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by Udjin Skobelev on 06.10.2018.
 */

public class SiteTemplateIntegrationTest extends AbstractApiIntegrationTest {
    @Test
    public void shouldGetSitesFromApi() {
        List<Site> sites = stackExchange.siteOperations().getActualSites();
        assertThat(sites).isNotEmpty();
    }
}
