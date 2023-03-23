package com.JLMSite.repository;

import com.JLMSite.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost,Long>{
	
	//Works because of blogpostinterface
	@Query(value="SELECT id as id, post_title as postTitle, post_date_time as postDateTime, uname FROM blogposts;", nativeQuery=true)
	List<BlogPostTitlesDatesAuthors> getListOfTitlesAndIds();
	
	@Query(value="SELECT id as id, post_title as postTitle, post_date_time as postDateTime FROM blogposts WHERE uname = ?1", nativeQuery=true)
	List<BlogPostTitlesDatesAuthors> getListOfBlogPostsByUsername(String uname);

	@Transactional
	@Modifying
	@Query(value="UPDATE blogposts SET post_content = ?1, post_title = ?2 WHERE id = ?3", nativeQuery=true)
	void updatePostContent(String postContent,String postTitle, Long id);


}