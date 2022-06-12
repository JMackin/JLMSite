package com.JLMthingsNstuff.JLMSite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JLMthingsNstuff.JLMSite.model.Post;
import com.JLMthingsNstuff.JLMSite.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public List<Post> getAllPosts()
	{
		return postRepository.findAll();
	}
	
	public void savePost(Post post)
	{
		postRepository.save(post);
	}
	
	public Post getPostById(Long id)
	{
		Optional<Post> post = postRepository.findById(id);
		
		if (!post.isPresent())
		{
			throw new RuntimeException("Cant find a post with that Id");
		}
		
		return post.get();
		
	}
	
	public String deletePostById(Long id)
	{
		Optional<Post> post = postRepository.findById(id);
		
		if (!post.isPresent())
		{
			throw new RuntimeException("No post with that ID");
		}
		
		return "Post titled " + post.get().getPostTitle() + " from " + post.get().getPostDateTime();
	}

}
