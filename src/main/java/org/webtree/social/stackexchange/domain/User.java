package org.webtree.social.stackexchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.webtree.social.stackexchange.converter.UnixTimestampToLocalDateTime;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {

    private Integer accountId;

    private boolean isEmployee;

    @JsonDeserialize(using = UnixTimestampToLocalDateTime.class)
    private LocalDateTime lastAccessDate;

    private Integer reputationChangeYear;

    private Integer reputationChangeQuarter;

    private Integer reputationChangeMonth;

    private Integer reputationChangeWeek;

    private Integer reputationChangeDay;

    private Integer reputation;

    @JsonDeserialize(using = UnixTimestampToLocalDateTime.class)
    private LocalDateTime creationDate;

    private String userType;

    private Integer userId;

    private String location;

    private String link;

    private String profileImage;

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

    public LocalDateTime getLastAccessDate() { return lastAccessDate; }

    public LocalDateTime getCreationDate() { return creationDate; }

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
        return Objects.hash(
                accountId,
                isEmployee,
                lastAccessDate,
                reputationChangeYear,
                reputationChangeQuarter,
                reputationChangeMonth,
                reputationChangeWeek,
                reputationChangeDay,
                reputation,
                creationDate,
                userType,
                userId,
                location,
                link,
                profileImage,
                displayName);
    }
}
