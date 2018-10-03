package org.webtree.social.stackexchange.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("account_id")
    private Integer accountId;

    @JsonProperty("is_employee")
    private boolean isEmployee;

    @JsonProperty("last_access_date")
    private Date lastAccessDate;

    @JsonProperty("reputation_change_year")
    private Integer reputationChangeYear;

    @JsonProperty("reputation_change_quarter")
    private Integer reputationChangeQuarter;

    @JsonProperty("reputation_change_month")
    private Integer reputationChangeMonth;

    @JsonProperty("reputation_change_week")
    private Integer reputationChangeWeek;

    @JsonProperty("reputation_change_day")
    private Integer reputationChangeDay;

    @JsonProperty("reputation")
    private Integer reputation;

    @JsonProperty("creation_date")
    private Date creationDate;

    @JsonProperty("user_type")
    private String userType;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("location")
    private String location;

    @JsonProperty("link")
    private String link;

    @JsonProperty("profile_image")
    private String profileImage;

    @JsonProperty("display_name")
    private String displayName;

    public Integer getAccountId() {
        return accountId;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    public Integer getReputationChangeYear() {
        return reputationChangeYear;
    }

    public Integer getReputationChangeQuarter() {
        return reputationChangeQuarter;
    }

    public Integer getReputationChangeMonth() {
        return reputationChangeMonth;
    }

    public Integer getReputationChangeWeek() {
        return reputationChangeWeek;
    }

    public Integer getReputationChangeDay() {
        return reputationChangeDay;
    }

    public Integer getReputation() {
        return reputation;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getUserType() {
        return userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLocation() {
        return location;
    }

    public String getLink() {
        return link;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getDisplayName() {
        return displayName;
    }
}
