package com.example.fw;

public class User {

	public String login;
	public String password;
	public String email;

	public User withLogin(String login) {
		this.login = login;
		// TODO Auto-generated method stub
		return this;
	}

	public User withPassword(String password) {
		this.password = password;
		// TODO Auto-generated method stub
		return this;
	}

	public User withEmail(String email) {
		this.email = email;
		// TODO Auto-generated method stub
		return this;
	}
	

}
