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
import com.JLMthingsNstuff.JLMSite.repository.BlogPostTitlesDatesAuthors;
import com.JLMthingsNstuff.JLMSite.service.IsEditableService;
import com.JLMthingsNstuff.JLMSite.service.BlogPostService;

@Controller
public class BlogPostController {
	
	@Autowired
	BlogPostService blogPostService;
	@Autowired
	IsEditableService isEditableService;
	
	@GetMapping("/MakeAPost")
	public String showMakePost(Model model)
	{
		
		BlogPost bp = new BlogPost();
		
		model.addAttribute("blogpost",bp);
		
		return "make_a_post";
	}
	
	@PostMapping("/SavePost")
	public String savePost(@ModelAttribute("blogpost") BlogPost blogPost)
	{

		blogPostService.savePost(blogPost);
		
		return "redirect:/";
	}
	
	@GetMapping("ViewAPost/{id}")
	public String viewPostById(@PathVariable Long id, Model model)
	{
		
		BlogPost bp = blogPostService.getPostById(id);
		boolean isEditable = isEditableService.isPostEditable(bp);
		
		model.addAttribute("editable",isEditable);
		model.addAttribute("blogpost", bp);
		
		return "view_a_Post";
	}
	
	@GetMapping("/BlogPosts")
	public String listBlogPosts(Model model)
	{

		List<BlogPostTitlesDatesAuthors> bpl = blogPostService.getListOfBlogEntryTitles();
		
		model.addAttribute("blogtitlelist",bpl);
		
		return "blog_posts";
	}
	
	
	
	@GetMapping("/EditAPost/{id}")
	public String showPostEditForm(@PathVariable Long id, Model model)
	{
		BlogPost bp = blogPostService.getPostById(id);
		
		if (isEditableService.isPostEditable(bp))
		{
			model.addAttribute("blogpost",bp);
			return "edit_blogPost";
		}else
		{
			return "redirect:/login";
		}
	}
	
	@PostMapping("/SubmitChanges")
	public String submitPostChanges(@ModelAttribute("blogpost") BlogPost bp)
	{
		Long postId = bp.getId();
		blogPostService.editBlogPost(bp);
		
		return "redirect:/ViewAPost/"+(postId.toString());
	}
	
	@GetMapping("/MyBlogPosts")
	public String showMyDashBoard(Model model)
	{
		
		List<BlogPostTitlesDatesAuthors> myPosts = blogPostService.getJustMyBlogPosts();
		
		model.addAttribute("postList",myPosts);
		
		return "my_blog_posts";
	}
	
	
	/*
	@GetMapping("/delete/{id}")
	public String deletePostById(@PathVariable Long id, Model model)
	{
		postService.deletePostById(id);
		
		return "redirect:/";
		
	}
	*/
	
}
