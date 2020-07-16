package com.optum.optumsample.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    public static final String NOT_EXISTING_RESOURCES = "firstName or lastName can't be null";
    public static final String NOT_EXISTING_RESOURCE = "There is no user";
    HttpStatus code;
    String msg;

    public CustomException(String msg, HttpStatus status) {
        this.msg = msg;
        this.code = status;
    }
}
