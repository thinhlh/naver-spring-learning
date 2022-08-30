package com.thinhlh.project1.exceptions;

import com.thinhlh.project1.config.constants.MessageConstants;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super(MessageConstants.RESOURCE_NOT_FOUND);
    }


    public NotFoundException(String message) {
        super(message);
    }
}
