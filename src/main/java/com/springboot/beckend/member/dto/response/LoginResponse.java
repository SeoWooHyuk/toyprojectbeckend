package com.springboot.beckend.member.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private String jwt;
    private String id;

    public LoginResponse(String jwt, String id) {
        this.jwt = jwt;
        this.id = id;
    }

}
