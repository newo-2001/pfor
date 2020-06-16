package com.groep6.pfor.exceptions;

/**
 * @author Bastiaan Jansen
 */
public class EmptyFieldException extends Exception {

    private final String message;

    /**
     * @param message
     */
    public EmptyFieldException(String message) {
        this.message = message;
    }

    public EmptyFieldException() {
        message = "Field cannot be empty";
    }

    /**
     * @return Exception message
     */
    public String getMessage() {
        return message;
    }
}
