package org.webtree.social.stackexchange.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Udjin Skobelev on 03.10.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Site {
    private String name;

    @JsonProperty("api_site_parameter")
    private String apiSiteParameter;

    public String getName() {
        return name;
    }

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }
}
