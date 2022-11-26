package com.manager.mangerexample.Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super (message);
    }
}
