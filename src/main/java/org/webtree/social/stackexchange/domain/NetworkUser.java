package org.webtree.social.stackexchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.webtree.social.stackexchange.converter.UnixTimestampToDate;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by Udjin Skobelev on 30.09.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class NetworkUser {

    private Integer questionCount;

    private Integer answerCount;

    @JsonDeserialize(using = UnixTimestampToDate.class)
    private LocalDateTime lastAccessDate;

    @JsonDeserialize(using = UnixTimestampToDate.class)
    private LocalDateTime creationDate;

    private Integer accountId;

    private Integer reputation;

    private Integer userId;

    private String siteUrl;

    private String siteName;

    public NetworkUser() {
    }

    public NetworkUser(Integer userId, String siteName) {
        this.userId = userId;
        this.siteName = siteName;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public LocalDateTime getLastAccessDate() { return lastAccessDate; }

    public LocalDateTime getCreationDate() { return creationDate; }

    public Integer getAccountId() {
        return accountId;
    }

    public Integer getReputation() {
        return reputation;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public String getSiteName() {
        return siteName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkUser that = (NetworkUser) o;
        return Objects.equals(questionCount, that.questionCount) &&
                Objects.equals(answerCount, that.answerCount) &&
                Objects.equals(lastAccessDate, that.lastAccessDate) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(reputation, that.reputation) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(siteUrl, that.siteUrl) &&
                Objects.equals(siteName, that.siteName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionCount, answerCount, lastAccessDate, creationDate, accountId, reputation, userId, siteUrl, siteName);
    }
}
