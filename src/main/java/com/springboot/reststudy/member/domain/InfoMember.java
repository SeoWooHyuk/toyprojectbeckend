package com.springboot.reststudy.member.domain;

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

    public String getId() {
    return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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
