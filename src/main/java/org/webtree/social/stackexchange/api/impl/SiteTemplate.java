package org.webtree.social.stackexchange.api.impl;

import org.springframework.web.client.RestTemplate;
import org.webtree.social.stackexchange.api.Api;
import org.webtree.social.stackexchange.api.Site;
import org.webtree.social.stackexchange.api.SiteOperations;

import java.util.List;

/**
 * Created by Udjin Skobelev on 04.10.2018.
 */

public class SiteTemplate implements SiteOperations {
    private final Api api;
    private final RestTemplate restTemplate;

    public SiteTemplate(Api api, RestTemplate restTemplate) {
        this.api = api;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Site> getActualSites() {
        return api.fetchResponseWrapper("sites",Site.class).getItems();
    }
}
