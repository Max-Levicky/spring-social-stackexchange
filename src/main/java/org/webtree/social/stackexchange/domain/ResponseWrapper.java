package org.webtree.social.stackexchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;

/**
 * Created by Udjin Skobelev on 30.09.2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResponseWrapper<T> {

    private List<T> items;

    private boolean hasMore;

    private Integer quotaMax;

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

    public boolean hasMore() {
        return hasMore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseWrapper<?> that = (ResponseWrapper<?>) o;
        return hasMore == that.hasMore &&
                Objects.equals(items, that.items) &&
                Objects.equals(quotaMax, that.quotaMax) &&
                Objects.equals(quotaRemaining, that.quotaRemaining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, hasMore, quotaMax, quotaRemaining);
    }
}

