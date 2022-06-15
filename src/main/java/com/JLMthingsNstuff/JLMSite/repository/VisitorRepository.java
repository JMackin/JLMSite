package com.JLMthingsNstuff.JLMSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JLMthingsNstuff.JLMSite.model.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
	// This will be AUTO IMPLEMENTED by Spring into a Bean
	
	

}
