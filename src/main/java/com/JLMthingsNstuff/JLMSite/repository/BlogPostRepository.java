package com.JLMthingsNstuff.JLMSite.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JLMthingsNstuff.JLMSite.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost,Long>{
	
	//Works because of blogpostinterface
	@Query(value="SELECT id as id, post_title as postTitle, post_date_time as postDateTime, uname FROM blogposts;", nativeQuery=true)
	List<BlogPostTitlesDatesAuthors> getListOfTitlesAndIds();
	
	@Query(value="SELECT id as id, post_title as postTitle, post_date_time as postDateTime FROM blogposts WHERE uname = ?1", nativeQuery=true)
	List<BlogPostTitlesDatesAuthors> getListOfBlogPostsByUsername(String uname);

	@Transactional
	@Modifying
	@Query(value="UPDATE blogposts SET post_content = ?1 WHERE id = ?2", nativeQuery=true)
	void updatePostContent(String postContent, Long id);


}