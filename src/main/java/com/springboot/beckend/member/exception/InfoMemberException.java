package com.springboot.beckend.member.exception;

import org.springframework.http.HttpStatus;

public class InfoMemberException extends RuntimeException {
    //RuntimeException 검사되지 않은 예외(unchekced exception)

    private HttpStatus status;

    public InfoMemberException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
