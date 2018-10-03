package org.webtree.social.stackexchange.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

/**
 * Created by Udjin Skobelev on 30.09.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseWrapper<T> {

    private List<T> items;

    @JsonProperty("has_more")
    private boolean hasmore;

    @JsonProperty("quota_max")
    private Integer quotaMax;

    @JsonProperty("quota_remaining")
    private Integer quotaRemaining;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }
}

