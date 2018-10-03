package org.webtree.social.stackexchange.api;

import java.util.List;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public interface UserOperations {
    List<User> getUserProfileAssociatedWithSite(String siteName);
    List<NetworkUser> getUserAssociatedAccounts();
}
