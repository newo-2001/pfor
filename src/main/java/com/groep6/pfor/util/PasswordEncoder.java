package com.groep6.pfor.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * PasswordEncoder is a class with methods related to passwords. i.e. hashing passwords.
 * @author Bastiaan Jansen
 */
public class PasswordEncoder {

    /**
     * Hash a password.
     * @param password
     * @return hashed password
     */
    public static String hash(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    /**
     * Check if password matches hashed password
     * @param password
     * @param passwordHash
     * @return Whether password matches hashed password
     */
    public static boolean matches(String password, String passwordHash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, passwordHash);
    }

}
