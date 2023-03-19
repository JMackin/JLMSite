package com.JLMSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JLMSite.model.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
	// This will be AUTO IMPLEMENTED by Spring into a Bean
	
	

}
