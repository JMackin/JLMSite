package com.JLMthingsNstuff.JLMSite.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
//import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.JLMthingsNstuff.JLMSite.model.BlogPost;
import com.JLMthingsNstuff.JLMSite.model.JLMUserDetails;
//import com.JLMthingsNstuff.JLMSite.model.User;
import com.JLMthingsNstuff.JLMSite.repository.BlogPostRepository;
import com.JLMthingsNstuff.JLMSite.repository.BlogPostsNamesAndDates;

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
		final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		String ldtS = sdf.format(ldt).toString();
		
		//Should maybe be decoupled... as per IoC principles
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String author = ((JLMUserDetails)principal).getUsername();
		
		blogPost.setPostDateTime(ldtS);
		blogPost.setPostAuthor(author);
		
		blogPostRepository.save(blogPost);
	}
	
	public BlogPost getPostById(Long id)
	{
		Optional<BlogPost> blogPost = blogPostRepository.findById(id);
		
		if (!blogPost.isPresent())
		{
			throw new RuntimeException("Cant find a post with that Id");
		}
		System.out.println(blogPost.get().getPostTitle());
		
		return blogPost.get();
		
	}
	
	public String deletePostById(Long id)
	{
		Optional<BlogPost> blogPost = blogPostRepository.findById(id);
		
		if (!blogPost.isPresent())
		{
			throw new RuntimeException("No post with that ID");
		}
		
		return "Post titled " + blogPost.get().getPostTitle() + " from " + blogPost.get().getPostDateTime();
	}
	
	public List<BlogPostsNamesAndDates> getListOfBlogEntryTitles()
	{
	
		return blogPostRepository.getListOfTitlesAndIds();
		
	}
	
	public boolean isPostEditable(BlogPost blogpost)
	{
		boolean isEditable;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		
		if (!principal.toString().equals("anonymousUser"))
		{
			
			String author = ((JLMUserDetails)principal).getUsername();
			
			isEditable = 
					(blogpost.getPostAuthor().equals(author)) ? true : 
						(auth != null && auth.getAuthorities().stream()
						.anyMatch(a -> a.getAuthority().equals("JLMMASTER")));
		}else
		{
			isEditable =false;
		}
		
		
		//Post is editable if:
		//- the principal isn't an anonymousUser
		//- the logged in user (the principal in securitycontext) has the same username as the post author
		//- OR the logged in user has role JLMMASTER
		
		return isEditable;
		
	}
	
}
