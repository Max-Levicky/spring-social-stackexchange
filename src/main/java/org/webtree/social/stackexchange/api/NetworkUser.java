package org.webtree.social.stackexchange.api;


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
}
