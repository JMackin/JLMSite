package com.JLMthingsNstuff.JLMSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JLMthingsNstuff.JLMSite.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost,Long>{
	
	
	
}
