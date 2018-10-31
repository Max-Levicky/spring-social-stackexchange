package org.webtree.social.stackexchange.api;

/**
 * Created by Udjin Skobelev on 11.10.2018.
 */

@FunctionalInterface
public interface ErrorHandler {
    void handle(StackExchangeError error);
}
