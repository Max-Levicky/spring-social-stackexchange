package org.webtree.social.stackexchange.api;

import org.webtree.social.stackexchange.domain.Site;

import java.util.List;

/**
 * Created by Udjin Skobelev on 04.10.2018.
 */
public interface SiteOperations {
    List<Site> getActualSites();
}
