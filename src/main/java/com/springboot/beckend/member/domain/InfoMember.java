package com.springboot.beckend.member.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoMember  {

    private String id;
    private String pwd;
    private String name;
	private String email;
    
    public InfoMember() {}

    public InfoMember(String id, String pw, String name, String email ,int auth) {
        super();
        this.id = id;
        this.pwd = pw;
  	    this.name = name;
		this.email = email;
    }

    @Override
	public String toString() {
		return "User{" +
			"id='" + id + '\'' +
			", pwd='" + pwd + '\'' +
			", name='" + name + '\'' +
			", email='" + email + '\'' +
			'}';
	}



}
