package com.JLMthingsNstuff.JLMSite.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.JLMthingsNstuff.JLMSite.service.JLMUserDetailsService;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
	
    @Autowired
    private DataSource dataSource;
    
     
    @Bean
    public UserDetailsService userDetailsService() {
        return new JLMUserDetailsService();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
    
    
    
    @Bean
    public SecurityFilterChain secFilterChain(HttpSecurity http) throws Exception
    {
    	AuthenticationManagerBuilder authenticationManagerBuilder =
    			http.getSharedObject(AuthenticationManagerBuilder.class);
    	
    	authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    	
    	AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
    	
    	
    	http
    		.authorizeHttpRequests((authz) -> authz
    				.antMatchers("/MakeAPost").authenticated()
    				.antMatchers("/MyBlogPosts").authenticated()
    				.anyRequest().permitAll()
    				)
    		.authenticationManager(authenticationManager)
    		.formLogin((flogin) -> flogin
    				.loginPage("/login") //<== using default login page for now
    				.usernameParameter("uname")
    				.defaultSuccessUrl("/MyBlogPosts")
    				.permitAll()
    				)
    		.logout((lo) -> lo
    		.logoutSuccessUrl("/login")
    		.permitAll());
    	
    	return http.build();
    	
    	
    }
}