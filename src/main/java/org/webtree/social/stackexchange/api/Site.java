package org.webtree.social.stackexchange.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Udjin Skobelev on 03.10.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Site {

    @JsonProperty("launch_date")
    private Date launchDate;

    @JsonProperty("open_beta_date")
    private Date openBetaDate;

    @JsonProperty("closed_beta_date")
    private Date closedBetaDate;

    @JsonProperty("site_state")
    private String siteState;

    @JsonProperty("twitter_account")
    private String twitterAccount;

    @JsonProperty("favicon_url")
    private String faviconUrl;

    @JsonProperty("icon_url")
    private String iconUrl;

    @JsonProperty("audience")
    private String audience;

    @JsonProperty("site_url")
    private String siteUrl;

    @JsonProperty("api_site_parameter")
    private String apiSiteParameter;

    @JsonProperty("logo_url")
    private String logoUrl;

    @JsonProperty("name")
    private String name;

    @JsonProperty("site_type")
    private String siteType;

    public Site() {
    }

    public Site(String apiSiteParameter, String name) {
        this.apiSiteParameter = apiSiteParameter;
        this.name = name;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public Date getOpenBetaDate() {
        return openBetaDate;
    }

    public Date getClosedBetaDate() {
        return closedBetaDate;
    }

    public String getSiteState() {
        return siteState;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public String getFaviconUrl() {
        return faviconUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getAudience() {
        return audience;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getName() {
        return name;
    }

    public String getSiteType() {
        return siteType;
    }
}
