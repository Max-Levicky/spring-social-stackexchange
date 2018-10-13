package org.webtree.social.stackexchange.api.impl.integration;


import org.junit.jupiter.api.Test;
import org.webtree.social.stackexchange.domain.Site;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by Udjin Skobelev on 06.10.2018.
 */

public class SiteTemplateIntegrationTest extends AbstractStackObjectFetcherIntegrationTest {
    private static String SELECTED_SITE = "stackoverflow";

    @Test
    public void shouldGetSitesFromApi() {
        List<Site> sites = stackExchange.siteOperations().getActualSites();
        assertThat(sites).isNotEmpty();
    }

    @Test
    public void shouldHasSelectedSiteInResponse() {
        List<Site> sites = stackExchange.siteOperations().getActualSites();
        Optional<Site> selectedSite = sites.stream().filter((site) -> site.getApiSiteParameter().equals(SELECTED_SITE)).findFirst();
        assertThat(selectedSite.isPresent()).isTrue();
        assertThat(selectedSite.get().getApiSiteParameter()).isNotEmpty();
        assertThat(selectedSite.get().getName()).isNotEmpty();
    }
}
