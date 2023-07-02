package com.JLMSite.service;

import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
//import java.util.Set;

import com.JLMSite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.JLMSite.model.BlogPost;
import com.JLMSite.model.JLMUserDetails;
//import com.JLMSite.model.User;
import com.JLMSite.repository.BlogPostRepository;
import com.JLMSite.repository.BlogPostTitlesDatesAuthors;


@Service

public class BlogPostService {
	
	@Autowired
	BlogPostRepository blogPostRepository;
	
	public List<BlogPost> getAllPosts()
	{
		return blogPostRepository.findAll();
	}
	
	public void savePost(BlogPost blogPost)
	{
		//Gotta update the date time column manually if the form doesnt pass a value to the model
		final LocalDateTime ldt = LocalDateTime.now();
		Timestamp ldtTS = Timestamp.valueOf(ldt);
		//String ldtS = sdf.format(ldt).toString();
		
		//Should maybe be decoupled... as per IoC principles
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


		if (principal.toString() != "anonymousUser")
		{
			JLMUserDetails uname = (JLMUserDetails) principal;
			blogPost.setUname(uname.getUsername());
		}else
		{
			blogPost.setUname(principal.toString());
		}

		blogPost.setPostDateTime(ldtTS);

		blogPostRepository.save(blogPost);
	}
	
	public BlogPost getPostById(Long id)
	{
		Optional<BlogPost> blogPost = blogPostRepository.findById(id);
		
		if (!blogPost.isPresent())
		{
			throw new RuntimeException("Cant find a post with that Id");
		}
		
		return blogPost.get();
		
	}
	
	public void deletePostById(Long id)
	{
		Optional<BlogPost> blogPost = blogPostRepository.findById(id);
		
		if (!blogPost.isPresent())
		{
			throw new RuntimeException("No post with that ID");
		}
		blogPostRepository.deleteBlogPostById(id);
		
//		return "Post titled " + blogPost.get().getPostTitle() + " from " + blogPost.get().getPostDateTime();
	}
	
	public List<BlogPostTitlesDatesAuthors> getListOfBlogEntryTitles()
	{
	
		return blogPostRepository.getListOfTitlesAndIds();
		
	}
	
	public List<BlogPostTitlesDatesAuthors> getJustMyBlogPosts()
	{

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		JLMUserDetails uname = (JLMUserDetails) principal;

		return blogPostRepository.getListOfBlogPostsByUsername(uname.getUsername());

	}
	
	public void editBlogPost(BlogPost blogPost, Long id)
	{

		String newTitle = blogPost.getPostTitle();
		String newContent = blogPost.getPostContent();
		
		blogPostRepository.updatePostContent(newContent,newTitle,id);
		
	}
	
	
}
