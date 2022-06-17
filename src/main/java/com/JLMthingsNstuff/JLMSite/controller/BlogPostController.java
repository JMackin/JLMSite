package com.JLMthingsNstuff.JLMSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
		
		model.addAttribute("blogpost",blogPost);
		
		return "makeApost";
	}
	
	@PostMapping("/SavePost")
	public String savePost(@ModelAttribute("blogpost") BlogPost blogPost)
	{
		//Gotta update the date time column manually if the form doesnt pass a value to the model
		final LocalDateTime ldt = LocalDateTime.now();
		final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		String ldtS = sdf.format(ldt).toString();
		
		//Should maybe be decoupled... as per IoC principles
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String author = ((UserDetails)principal).getUsername();
		
		blogPost.setPostDateTime(ldtS);
		blogPost.setPostAuthor(author);
		
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
