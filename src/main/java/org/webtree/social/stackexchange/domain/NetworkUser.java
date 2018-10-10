package org.webtree.social.stackexchange.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.webtree.social.stackexchange.converter.UnixTimestampToDate;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Udjin Skobelev on 30.09.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkUser {

    @JsonProperty("question_count")
    private Integer questionCount;

    @JsonProperty("answer_count")
    private Integer answerCount;

    @JsonDeserialize(using = UnixTimestampToDate.class)
    @JsonProperty("last_access_date")
    private Date lastAccessDate;

    @JsonDeserialize(using = UnixTimestampToDate.class)
    @JsonProperty("creation_date")
    private Date creationDate;

    @JsonProperty("account_id")
    private Integer accountId;

    private Integer reputation;
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("site_url")
    private String siteUrl;

    @JsonProperty("site_name")
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

    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

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
