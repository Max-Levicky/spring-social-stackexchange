package org.webtree.social.stackexchange.api;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */
public interface StackExchange {
    UserOperations userOperations();
    SiteOperations siteOperations();
    NetworkUserOperations networkUserOperations();
}
