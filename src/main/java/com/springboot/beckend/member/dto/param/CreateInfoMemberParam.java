package com.springboot.beckend.member.dto.param;


import com.springboot.beckend.member.dto.request.JoinRequest;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateInfoMemberParam  {

    private String id;
    private String name;
    private String pwd;
    private String email;


    public CreateInfoMemberParam(JoinRequest req ,String encodedPwd) {
        this.id = req.getId();
        this.pwd = encodedPwd;
  	    this.name = req.getName();
		this.email = req.getEmail();
    }


}
