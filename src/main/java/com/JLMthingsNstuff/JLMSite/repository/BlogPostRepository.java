package com.JLMthingsNstuff.JLMSite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JLMthingsNstuff.JLMSite.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost,Long>{
	
	//Works because of blogpostinterface
	@Query(value="SELECT id as id, post_title as postTitle, post_date_time as postDateTime, post_author as postAuthor FROM blogposts;", nativeQuery=true)
	List<BlogPostTitlesDatesAuthors> getListOfTitlesAndIds();
	
	@Query(value="SELECT id as id, post_title as postTitle, post_date_time as postDateTime FROM blogposts WHERE post_author = ?1", nativeQuery=true)
	List<BlogPostTitlesDatesAuthors> getListOfBlogPostsByUsername(String uname);
	//TODO
	//Connect blogposts with their usernames by ID via foreign key or something more sensible..
	
}

