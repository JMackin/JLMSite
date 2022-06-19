package com.JLMthingsNstuff.JLMSite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.JLMthingsNstuff.JLMSite.model.BlogPost;
import com.JLMthingsNstuff.JLMSite.model.JLMUserDetails;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class JlmSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(JlmSiteApplication.class, args);
		
			
	}

}
