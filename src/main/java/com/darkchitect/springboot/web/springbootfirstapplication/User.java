package com.darkchitect.springboot.web.springbootfirstapplication;

public class User {

	Long userNumber;
	String username;
	String password;
	public User(Long userNumber, String username, String password) {
		super();
		this.userNumber = userNumber;
		this.username = username;
		this.password = password;
	}
	public Long getUserNumber() {
		return userNumber;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	
}
