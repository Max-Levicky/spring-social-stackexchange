package org.webtree.social.stackexchange.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;

/**
 * Created by Udjin Skobelev on 30.09.2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObject<T> {

    private List<T> items;
    @JsonAlias("has_more")
    boolean hasmore;
    @JsonAlias("quota_max")
    private Integer quotaMax;
    @JsonAlias("quota_remaining")
    private Integer quotaRemaining;


    public List<?> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }
}

