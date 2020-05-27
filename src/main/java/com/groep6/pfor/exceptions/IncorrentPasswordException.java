package com.groep6.pfor.exceptions;

public class IncorrentPasswordException extends Exception {

    private String message;

    public IncorrentPasswordException(String message) {
        this.message = message;
    }

    public IncorrentPasswordException() {
        message = "Incorrect password";
    }

    public String getMessage() {
        return message;
    }
}
