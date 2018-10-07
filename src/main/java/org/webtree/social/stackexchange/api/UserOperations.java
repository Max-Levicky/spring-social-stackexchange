package org.webtree.social.stackexchange.api;

import org.webtree.social.stackexchange.domain.NetworkUser;
import org.webtree.social.stackexchange.domain.User;

import java.util.List;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public interface UserOperations {
    List<User> getUserProfileAssociatedWithSite(String siteName);
    List<NetworkUser> getUserAssociatedAccounts();
}
