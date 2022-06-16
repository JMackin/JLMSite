package com.JLMthingsNstuff.JLMSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.JLMthingsNstuff.JLMSite.model.User;
import com.JLMthingsNstuff.JLMSite.service.ListUsersService;

@Controller
public class ListUsersController {
	
	@Autowired
	ListUsersService listUsersService;
	

	@GetMapping("/listOfUsers")
	public String listUsers(Model model) {
		
	    List<User> listOfUsers = listUsersService.listUsers();
	    
	    model.addAttribute("listOfUsers", listOfUsers);
	     
	    return "listOfUsers";
	}
	
}