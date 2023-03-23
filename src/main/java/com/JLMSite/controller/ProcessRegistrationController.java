package com.JLMSite.controller;

import com.JLMSite.repository.UserRepository;
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
	@Autowired
	private UserRepository userRepository;


	@PostMapping("/process_register")
	public String processUser(User user)
	{

		boolean emailExists = false;
		String email = userRepository.existsByEmail(user.getEmail());
		if (email != null)
		{
			emailExists = true;
		}

		if (!emailExists){
			userRegistrationService.processRegistration(user);
			return "registrationSuccess";
		}else{
			return "register";
		}

	}
	
	

}
