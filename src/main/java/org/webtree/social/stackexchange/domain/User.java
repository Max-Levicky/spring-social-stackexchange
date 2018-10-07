package org.webtree.social.stackexchange.domain;

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

        if (isEmployee != user.isEmployee) return false;
        if (accountId != null ? !accountId.equals(user.accountId) : user.accountId != null) return false;
        if (lastAccessDate != null ? !lastAccessDate.equals(user.lastAccessDate) : user.lastAccessDate != null)
            return false;
        if (reputationChangeYear != null ? !reputationChangeYear.equals(user.reputationChangeYear) : user.reputationChangeYear != null)
            return false;
        if (reputationChangeQuarter != null ? !reputationChangeQuarter.equals(user.reputationChangeQuarter) : user.reputationChangeQuarter != null)
            return false;
        if (reputationChangeMonth != null ? !reputationChangeMonth.equals(user.reputationChangeMonth) : user.reputationChangeMonth != null)
            return false;
        if (reputationChangeWeek != null ? !reputationChangeWeek.equals(user.reputationChangeWeek) : user.reputationChangeWeek != null)
            return false;
        if (reputationChangeDay != null ? !reputationChangeDay.equals(user.reputationChangeDay) : user.reputationChangeDay != null)
            return false;
        if (reputation != null ? !reputation.equals(user.reputation) : user.reputation != null) return false;
        if (creationDate != null ? !creationDate.equals(user.creationDate) : user.creationDate != null) return false;
        if (userType != null ? !userType.equals(user.userType) : user.userType != null) return false;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (location != null ? !location.equals(user.location) : user.location != null) return false;
        if (link != null ? !link.equals(user.link) : user.link != null) return false;
        if (profileImage != null ? !profileImage.equals(user.profileImage) : user.profileImage != null) return false;
        return displayName != null ? displayName.equals(user.displayName) : user.displayName == null;
    }

    @Override
    public int hashCode() {
        int result = accountId != null ? accountId.hashCode() : 0;
        result = 31 * result + (isEmployee ? 1 : 0);
        result = 31 * result + (lastAccessDate != null ? lastAccessDate.hashCode() : 0);
        result = 31 * result + (reputationChangeYear != null ? reputationChangeYear.hashCode() : 0);
        result = 31 * result + (reputationChangeQuarter != null ? reputationChangeQuarter.hashCode() : 0);
        result = 31 * result + (reputationChangeMonth != null ? reputationChangeMonth.hashCode() : 0);
        result = 31 * result + (reputationChangeWeek != null ? reputationChangeWeek.hashCode() : 0);
        result = 31 * result + (reputationChangeDay != null ? reputationChangeDay.hashCode() : 0);
        result = 31 * result + (reputation != null ? reputation.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (profileImage != null ? profileImage.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        return result;
    }
}
