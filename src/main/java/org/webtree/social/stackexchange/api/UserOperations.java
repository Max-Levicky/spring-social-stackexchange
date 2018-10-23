package org.webtree.social.stackexchange.api;

import org.webtree.social.stackexchange.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Udjin Skobelev on 27.09.2018.
 */

public interface UserOperations {
    Optional<User> getUserProfileBySiteName(String siteName);
}
