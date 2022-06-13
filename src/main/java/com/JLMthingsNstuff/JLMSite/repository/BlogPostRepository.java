package com.JLMthingsNstuff.JLMSite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JLMthingsNstuff.JLMSite.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost,Long>{
	
	//Works because of blogpostinterface
	@Query(value="SELECT id as id, post_title as postTitle, post_date_time as postDateTime from blogposts;", nativeQuery=true)
	List<BlogPostsNamesAndDates> getListOfTitlesAndIds();
	
}

