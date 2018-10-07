package org.webtree.social.stackexchange.domain;

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
    private boolean hasMore;

    @JsonProperty("quota_max")
    private Integer quotaMax;

    @JsonProperty("quota_remaining")
    private Integer quotaRemaining;

    public ResponseWrapper(List<T> items, boolean hasMore, Integer quotaMax, Integer quotaRemaining) {
        this.items = items;
        this.hasMore = hasMore;
        this.quotaMax = quotaMax;
        this.quotaRemaining = quotaRemaining;
    }

    public ResponseWrapper() {
    }

    public List<T> getItems() {
        return items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }
}

