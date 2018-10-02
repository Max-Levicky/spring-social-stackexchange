package org.webtree.social.stackexchange.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonAlias("account_id")
    private Integer accountId;
    @JsonAlias("is_employee")
    private boolean isEmployee;
    @JsonAlias("last_access_date")
    private Date lastAccessDate;
    @JsonAlias("reputation_change_year")
    private Integer reputationChangeYear;
    @JsonAlias("reputation_change_quarter")
    private Integer reputationChangeQuarter;
    @JsonAlias("reputation_change_month")
    private Integer reputationChangeMonth;
    @JsonAlias("reputation_change_week")
    private Integer reputationChangeWeek;
    @JsonAlias("reputation_change_day")
    private Integer reputationChangeDay;
    @JsonAlias("reputation")
    private Integer reputation;
    @JsonAlias("creation_date")
    private Date creationDate;
    @JsonAlias("user_type")
    private String userType;
    @JsonAlias("user_id")
    private Integer userId;
    @JsonAlias("location")
    private String location;
    @JsonAlias("link")
    private String link;
    @JsonAlias("profile_image")
    private String profileImage;
    @JsonAlias("display_name")
    private String displayName;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Date lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public Integer getReputationChangeYear() {
        return reputationChangeYear;
    }

    public void setReputationChangeYear(Integer reputationChangeYear) {
        this.reputationChangeYear = reputationChangeYear;
    }

    public Integer getReputationChangeQuarter() {
        return reputationChangeQuarter;
    }

    public void setReputationChangeQuarter(Integer reputationChangeQuarter) {
        this.reputationChangeQuarter = reputationChangeQuarter;
    }

    public Integer getReputationChangeMonth() {
        return reputationChangeMonth;
    }

    public void setReputationChangeMonth(Integer reputationChangeMonth) {
        this.reputationChangeMonth = reputationChangeMonth;
    }

    public Integer getReputationChangeWeek() {
        return reputationChangeWeek;
    }

    public void setReputationChangeWeek(Integer reputationChangeWeek) {
        this.reputationChangeWeek = reputationChangeWeek;
    }

    public Integer getReputationChangeDay() {
        return reputationChangeDay;
    }

    public void setReputationChangeDay(Integer reputationChangeDay) {
        this.reputationChangeDay = reputationChangeDay;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
