package com.darkchitect.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String username, String password) {
		return username.equalsIgnoreCase("Anteuz") && password.equalsIgnoreCase("dummy");
	}
	
}
