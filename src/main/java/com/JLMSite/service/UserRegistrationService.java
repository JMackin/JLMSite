package com.JLMSite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.JLMSite.model.User;
import com.JLMSite.model.User.Roles;
import com.JLMSite.repository.UserRepository;

@Service
public class UserRegistrationService {
	
	
	@Autowired
	UserRepository userRepository;
	
	public void processRegistration(User user) {
		
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    
	    user.setRole(Roles.valueOf("REGUSER"));
		user.setEnabled(true);
		userRepository.save(user);
	     
	   
	}

}
