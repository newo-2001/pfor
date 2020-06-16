package com.groep6.pfor.exceptions;

/**
 * IncorrectPasswordException for lobby login
 * @author Bastiaan Jansen
 */
public class UsernameAlreadyUsed extends Exception {

    private final String message;

    /**
     * @param message
     */
    public UsernameAlreadyUsed(String message) {
        this.message = message;
    }

    public UsernameAlreadyUsed() {
        message = "Username already used";
    }

    /**
     * @return Exception message
     */
    public String getMessage() {
        return message;
    }
}
