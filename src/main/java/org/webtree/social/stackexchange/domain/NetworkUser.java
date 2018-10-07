package org.webtree.social.stackexchange.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Udjin Skobelev on 30.09.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkUser {

    @JsonProperty("question_count")
    private Integer questionCount;

    @JsonProperty("answer_count")
    private Integer answerCount;

    @JsonProperty("last_access_date")
    private Date lastAccessDate;

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

        if (questionCount != null ? !questionCount.equals(that.questionCount) : that.questionCount != null)
            return false;
        if (answerCount != null ? !answerCount.equals(that.answerCount) : that.answerCount != null) return false;
        if (lastAccessDate != null ? !lastAccessDate.equals(that.lastAccessDate) : that.lastAccessDate != null)
            return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (reputation != null ? !reputation.equals(that.reputation) : that.reputation != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (siteUrl != null ? !siteUrl.equals(that.siteUrl) : that.siteUrl != null) return false;
        return siteName != null ? siteName.equals(that.siteName) : that.siteName == null;
    }

    @Override
    public int hashCode() {
        int result = questionCount != null ? questionCount.hashCode() : 0;
        result = 31 * result + (answerCount != null ? answerCount.hashCode() : 0);
        result = 31 * result + (lastAccessDate != null ? lastAccessDate.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (reputation != null ? reputation.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (siteUrl != null ? siteUrl.hashCode() : 0);
        result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
        return result;
    }
}
