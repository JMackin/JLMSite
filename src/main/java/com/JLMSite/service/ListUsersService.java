package com.JLMSite.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Service;

import com.JLMSite.model.User;
import com.JLMSite.repository.UserRepository;

@Service
public class ListUsersService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> listUsers() {
		
	    List<User> listUsers = userRepo.findAll();
	     
	    return listUsers;
	}

}
