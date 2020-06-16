package com.groep6.pfor.exceptions;

/**
 * IncorrectPasswordException for lobby login
 * @author Bastiaan Jansen
 */
public class IncorrentPasswordException extends Exception {

    private final String message;

    /**
     * @param message
     */
    public IncorrentPasswordException(String message) {
        this.message = message;
    }

    public IncorrentPasswordException() {
        message = "Incorrect password";
    }

    /**
     * @return Exception message
     */
    public String getMessage() {
        return message;
    }
}
