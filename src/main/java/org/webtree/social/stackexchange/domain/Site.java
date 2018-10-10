package org.webtree.social.stackexchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.webtree.social.stackexchange.converter.UnixTimestampToDate;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Udjin Skobelev on 03.10.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Site {

    @JsonDeserialize(using = UnixTimestampToDate.class)
    @JsonProperty("launch_date")
    private Date launchDate;

    @JsonDeserialize(using = UnixTimestampToDate.class)
    @JsonProperty("open_beta_date")
    private Date openBetaDate;

    @JsonDeserialize(using = UnixTimestampToDate.class)
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
        return Objects.equals(launchDate, site.launchDate) &&
                Objects.equals(openBetaDate, site.openBetaDate) &&
                Objects.equals(closedBetaDate, site.closedBetaDate) &&
                Objects.equals(siteState, site.siteState) &&
                Objects.equals(twitterAccount, site.twitterAccount) &&
                Objects.equals(faviconUrl, site.faviconUrl) &&
                Objects.equals(iconUrl, site.iconUrl) &&
                Objects.equals(audience, site.audience) &&
                Objects.equals(siteUrl, site.siteUrl) &&
                Objects.equals(apiSiteParameter, site.apiSiteParameter) &&
                Objects.equals(logoUrl, site.logoUrl) &&
                Objects.equals(name, site.name) &&
                Objects.equals(siteType, site.siteType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(launchDate, openBetaDate, closedBetaDate, siteState, twitterAccount, faviconUrl, iconUrl, audience, siteUrl, apiSiteParameter, logoUrl, name, siteType);
    }
}
