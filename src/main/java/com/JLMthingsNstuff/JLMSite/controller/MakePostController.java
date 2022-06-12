package com.JLMthingsNstuff.JLMSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JLMthingsNstuff.JLMSite.model.Post;
import com.JLMthingsNstuff.JLMSite.service.PostService;

@Controller
public class MakePostController {
	
	@Autowired
	PostService postService;

	@GetMapping("/MakeAPost")
	public String showMakePost(Model model)
	{
		Post post = new Post();
		
		model.addAttribute("post",post);
		
		return "makeApost";
	}
	
	@PostMapping("/SavePost")
	public String savePost(@ModelAttribute("post") Post post)
	{
		postService.savePost(post);
		
		return "redirect:/";
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
