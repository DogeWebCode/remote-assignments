package org.school.assignment3.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class BCryptUtil {
    private static final Logger logger = LoggerFactory.getLogger(BCryptUtil.class);
    private static final int WORK_FACTOR = 12;

    public static String encodePassword(String password) {
        String encodePassword = BCrypt.hashpw(password, BCrypt.gensalt(WORK_FACTOR));
        logger.debug("Password encoded successfully");
        return encodePassword;
    }

    public static boolean verifyPassword(String password, String encodePassword) {
        boolean isVerifyPassword = BCrypt.checkpw(password, encodePassword);
        logger.debug("Password verification: {}", isVerifyPassword);
        return isVerifyPassword;
    }
}
