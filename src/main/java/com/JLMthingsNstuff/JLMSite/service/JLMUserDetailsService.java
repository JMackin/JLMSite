package com.JLMthingsNstuff.JLMSite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.JLMthingsNstuff.JLMSite.model.JLMUserDetails;
import com.JLMthingsNstuff.JLMSite.model.User;
import com.JLMthingsNstuff.JLMSite.repository.UserRepository;

public class JLMUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepo;
     
    @Override
    public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
        User user = userRepo.findByUname(uname);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        
        return new JLMUserDetails(user);
    }
    
}
