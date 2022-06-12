package com.JLMthingsNstuff.JLMSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JLMthingsNstuff.JLMSite.model.Post;

public interface PostRepository extends JpaRepository<Post,Long>{
	
	
	
}
