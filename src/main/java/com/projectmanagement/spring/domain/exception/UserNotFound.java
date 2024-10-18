package com.projectmanagement.spring.domain.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message){super(message);}
}
