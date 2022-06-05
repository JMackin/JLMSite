package com.JLMthingsNstuff.JLMSite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String index()
	{
		return "Welcome to JLMSite, all things John Luther Mackin!";
	}
	
	
}
