package org.webtree.social.stackexchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.webtree.social.stackexchange.converter.UnixTimestampToDate;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("account_id")
    private Integer accountId;

    @JsonProperty("is_employee")
    private boolean isEmployee;

    @JsonDeserialize(using = UnixTimestampToDate.class)
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

    @JsonDeserialize(using = UnixTimestampToDate.class)
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

    public User() {
    }

    public User(Integer accountId, Integer userId, String displayName) {
        this.accountId = accountId;
        this.userId = userId;
        this.displayName = displayName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isEmployee == user.isEmployee &&
                Objects.equals(accountId, user.accountId) &&
                Objects.equals(lastAccessDate, user.lastAccessDate) &&
                Objects.equals(reputationChangeYear, user.reputationChangeYear) &&
                Objects.equals(reputationChangeQuarter, user.reputationChangeQuarter) &&
                Objects.equals(reputationChangeMonth, user.reputationChangeMonth) &&
                Objects.equals(reputationChangeWeek, user.reputationChangeWeek) &&
                Objects.equals(reputationChangeDay, user.reputationChangeDay) &&
                Objects.equals(reputation, user.reputation) &&
                Objects.equals(creationDate, user.creationDate) &&
                Objects.equals(userType, user.userType) &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(location, user.location) &&
                Objects.equals(link, user.link) &&
                Objects.equals(profileImage, user.profileImage) &&
                Objects.equals(displayName, user.displayName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(accountId, isEmployee, lastAccessDate, reputationChangeYear, reputationChangeQuarter, reputationChangeMonth, reputationChangeWeek, reputationChangeDay, reputation, creationDate, userType, userId, location, link, profileImage, displayName);
    }
}
