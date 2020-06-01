package com.groep6.pfor.exceptions;

/**
 * @author Bastiaan Jansen
 */
public class NoDocumentException extends Exception {

    private String message;

    /**
     * @param message
     */
    public NoDocumentException(String message) {
        this.message = message;
    }

    public NoDocumentException() {
        message = "No such document";
    }

    /**
     * @return Exception message
     */
    public String getMessage() {
        return message;
    }
}
