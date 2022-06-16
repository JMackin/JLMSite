package com.JLMthingsNstuff.JLMSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.JLMthingsNstuff.JLMSite.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	//This dumb query wont work..
	@Query(value="SELECT * FROM users WHERE email = ?1", nativeQuery=true)
	public User findByEmail(String email);
	
}