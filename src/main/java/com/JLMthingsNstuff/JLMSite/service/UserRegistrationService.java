package com.JLMthingsNstuff.JLMSite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.JLMthingsNstuff.JLMSite.model.User;
import com.JLMthingsNstuff.JLMSite.repository.UserRepository;

@Service
public class UserRegistrationService {
	
	
	@Autowired
	UserRepository userRepository;
	
	public void processRegistration(User user) {
		
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	     
	   userRepository.save(user);
	     
	   
	}

}
