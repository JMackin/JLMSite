package com.JLMthingsNstuff.JLMSite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JLMthingsNstuff.JLMSite.model.BlogPost;
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
		for (BlogPostsNamesAndDates i : blogPostRepository.getListOfTitlesAndIds())
		{
			System.out.println(i.getPostTitle());
		}
	
		return blogPostRepository.getListOfTitlesAndIds();
		
	}

}
