package com.thinhlh.btvn14.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Resource Not Found!");
    }


    public NotFoundException(String message) {
        super(message);
    }
}
