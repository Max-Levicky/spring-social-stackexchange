package org.webtree.social.stackexchange.domain;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Site site = (Site) o;

        if (launchDate != null ? !launchDate.equals(site.launchDate) : site.launchDate != null) return false;
        if (openBetaDate != null ? !openBetaDate.equals(site.openBetaDate) : site.openBetaDate != null) return false;
        if (closedBetaDate != null ? !closedBetaDate.equals(site.closedBetaDate) : site.closedBetaDate != null)
            return false;
        if (siteState != null ? !siteState.equals(site.siteState) : site.siteState != null) return false;
        if (twitterAccount != null ? !twitterAccount.equals(site.twitterAccount) : site.twitterAccount != null)
            return false;
        if (faviconUrl != null ? !faviconUrl.equals(site.faviconUrl) : site.faviconUrl != null) return false;
        if (iconUrl != null ? !iconUrl.equals(site.iconUrl) : site.iconUrl != null) return false;
        if (audience != null ? !audience.equals(site.audience) : site.audience != null) return false;
        if (siteUrl != null ? !siteUrl.equals(site.siteUrl) : site.siteUrl != null) return false;
        if (apiSiteParameter != null ? !apiSiteParameter.equals(site.apiSiteParameter) : site.apiSiteParameter != null)
            return false;
        if (logoUrl != null ? !logoUrl.equals(site.logoUrl) : site.logoUrl != null) return false;
        if (name != null ? !name.equals(site.name) : site.name != null) return false;
        return siteType != null ? siteType.equals(site.siteType) : site.siteType == null;
    }

    @Override
    public int hashCode() {
        int result = launchDate != null ? launchDate.hashCode() : 0;
        result = 31 * result + (openBetaDate != null ? openBetaDate.hashCode() : 0);
        result = 31 * result + (closedBetaDate != null ? closedBetaDate.hashCode() : 0);
        result = 31 * result + (siteState != null ? siteState.hashCode() : 0);
        result = 31 * result + (twitterAccount != null ? twitterAccount.hashCode() : 0);
        result = 31 * result + (faviconUrl != null ? faviconUrl.hashCode() : 0);
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode() : 0);
        result = 31 * result + (audience != null ? audience.hashCode() : 0);
        result = 31 * result + (siteUrl != null ? siteUrl.hashCode() : 0);
        result = 31 * result + (apiSiteParameter != null ? apiSiteParameter.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (siteType != null ? siteType.hashCode() : 0);
        return result;
    }
}
