package com.JLMSite.service;

import com.JLMSite.model.JLMUserDetails;
import com.JLMSite.model.User;
import com.JLMSite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JLMUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {

        User user = userRepository.findByUname(uname);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        
        return new JLMUserDetails(user);
    }
    
}
