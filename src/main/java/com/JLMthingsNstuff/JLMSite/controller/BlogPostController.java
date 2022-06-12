package com.JLMthingsNstuff.JLMSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JLMthingsNstuff.JLMSite.model.BlogPost;
import com.JLMthingsNstuff.JLMSite.repository.BlogPostsNamesAndDates;
import com.JLMthingsNstuff.JLMSite.service.BlogPostService;

@Controller
public class BlogPostController {
	
	@Autowired
	BlogPostService blogPostService;

	@GetMapping("/MakeAPost")
	public String showMakePost(Model model)
	{
		BlogPost blogPost = new BlogPost();
		
		model.addAttribute("post",blogPost);
		
		return "makeApost";
	}
	
	@PostMapping("/SavePost")
	public String savePost(@ModelAttribute("post") BlogPost blogPost)
	{
		blogPostService.savePost(blogPost);
		
		return "redirect:/";
	}
	
	@GetMapping("viewAPost/{id}")
	public String viewPostById(@PathVariable Long id, Model model)
	{
		
		BlogPost bp = blogPostService.getPostById(id);
		
		model.addAttribute("blogpost", bp);
		
		return "viewAPost";
	}
	
	@GetMapping("/blogPosts")
	public String listBlogPosts(Model model)
	{

		List<BlogPostsNamesAndDates> bpl = blogPostService.getListOfBlogEntryTitles();
		
		model.addAttribute("blogtitlelist",bpl);
		
		return "blogPosts";
	}
	
	
	/*
	@GetMapping ("editAPost/{id}")
	public String showPostEditForm(@PathVariable Long id, Model model)
	{
		Post post = postService.getPostById(id);
		
		model.addAttribute("post",post);
		
		return "edit_post";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePostById(@PathVariable Long id, Model model)
	{
		postService.deletePostById(id);
		
		return "redirect:/";
		
	}
	*/
	
}
