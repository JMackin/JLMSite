package com.JLMthingsNstuff.JLMSite.DataBaseAction;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	
}
