package com.PExceptions;


public class UniqueConstrainException extends Exception {
    public UniqueConstrainException(String message) {
        super(message);
    }

    public UniqueConstrainException(String message, Throwable cause) {
        super(message, cause);
    }
}
