package com.compfest.sea.exception;

public class InvalidAdminTokenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidAdminTokenException(String resource) {
        super(resource);
    }
}
