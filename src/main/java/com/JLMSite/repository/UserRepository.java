package com.JLMSite.repository;

import com.JLMSite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="SELECT email FROM users WHERE email = ?1", nativeQuery=true)
	public String existsByEmail(String email);

	
	@Query(value="SELECT * FROM users WHERE uname = ?1", nativeQuery=true)
	public User findByUname(String uname);

}