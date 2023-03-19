package com.JLMSite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.JLMSite.model.User;
import com.JLMSite.service.UserRegistrationService;

@Controller
public class ProcessRegistrationController {
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
	
	@PostMapping("/process_register")
	public String processUser(User user)
	{
		userRegistrationService.processRegistration(user);
		
		return "registrationSuccess";
	}
	
	

}
