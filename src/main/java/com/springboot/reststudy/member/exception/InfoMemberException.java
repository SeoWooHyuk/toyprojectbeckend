package com.springboot.reststudy.member.exception;

import org.springframework.http.HttpStatus;

public class InfoMemberException extends RuntimeException {

    private HttpStatus status;

    public InfoMemberException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
