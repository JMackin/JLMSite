package com.JLMSite.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import com.JLMSite.model.BlogPost;
import com.JLMSite.model.JLMUserDetails;

@Service
public class IsEditableService{

	
	public boolean isPostEditable(BlogPost blogpost)
	{
		boolean isEditable;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		//TODO use .isAnonymous() function instead
		if (!principal.toString().equals("anonymousUser"))
		{

			JLMUserDetails jlmUserDetails = (JLMUserDetails) principal;
			String author = jlmUserDetails.getUsername();

			isEditable = 
					(blogpost.getUname().equals(author)) ? true : 
						(auth != null && auth.getAuthorities().stream()
						.anyMatch(a -> a.getAuthority().equals("JLMMASTER")));
		}else
		{
			isEditable = false;
		}
		
		
		//Post is editable if:
		//- the principal isn't an anonymousUser
		//- the logged in user (the principal in securitycontext) has the same username as the post author
		//- OR the logged in user has role JLMMASTER
		
		return isEditable;
		
	}
	
	

}
