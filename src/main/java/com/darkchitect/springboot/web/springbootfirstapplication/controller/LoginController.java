package com.darkchitect.springboot.web.springbootfirstapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.darkchitect.springboot.web.service.LoginService;

/*
 * Handles the simple login
 */
@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String showLoginPage(ModelMap model) {
		model.put("name", "Anteuz");
		return "welcome";
	}
	

	
	
}
