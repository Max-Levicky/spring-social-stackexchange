package org.webtree.social.stackexchange.api;

import org.webtree.social.stackexchange.domain.NetworkUser;

import java.util.List;

/**
 * Created by Udjin Skobelev on 20.10.2018.
 */

public interface NetworkUserOperations {
    List<NetworkUser> getUserAssociatedAccounts();
}
