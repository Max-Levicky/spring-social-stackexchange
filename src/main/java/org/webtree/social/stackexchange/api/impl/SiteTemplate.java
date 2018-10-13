package org.webtree.social.stackexchange.api.impl;

import org.webtree.social.stackexchange.api.StackObjectFetcher;
import org.webtree.social.stackexchange.domain.Site;
import org.webtree.social.stackexchange.api.SiteOperations;

import java.util.List;

/**
 * Created by Udjin Skobelev on 04.10.2018.
 */

public class SiteTemplate implements SiteOperations {
    private StackObjectFetcher stackObjectFetcher;

    public SiteTemplate(StackObjectFetcher stackObjectFetcher) {
        this.stackObjectFetcher = stackObjectFetcher;
    }

    @Override
    public List<Site> getActualSites() {
        return stackObjectFetcher.fetchObject("sites", Site.class).getItems();
    }
}
