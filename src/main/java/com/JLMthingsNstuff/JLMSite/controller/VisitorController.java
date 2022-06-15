package com.JLMthingsNstuff.JLMSite.controller;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JLMthingsNstuff.JLMSite.model.Visitor;
import com.JLMthingsNstuff.JLMSite.service.VisitorService;

@Controller		//This means this class is a controller (duh) the C in MVC
public class VisitorController {

	@Autowired
	// This means to get the bean which is auto-generated by Spring
	// We will use a VisitorService for each
	VisitorService visitorService;
	
	//display list of visitors
	@GetMapping("/ListOfVisitors") //This method will be called when a GET request is sent to that URL extension
	public String viewListOfVisitors(Model model)
	{
		//	We can use this attribute "visitorList" to perform server-side rendering of the HTML with Thymeleaf.
		//	We set all visitors data to "visitorList"
		model.addAttribute("visitorList",visitorService.getAllVisitors());
		
		//show the visitorlist.html template
		return "visitorlist";
	}
	
	// show new visitor form
	@GetMapping("/NewVisitorForm")
	public String showNewVisitorForm(Model model) //Model is an interface that defines a holder for attributes, 
	//normally used for adding attributes
	{
		Visitor vis = new Visitor();
		
		//We can use this attribute "visitor" to perform server-side rendering of the HTML with Thymeleaf.
		model.addAttribute("visitor",vis);
		
		//show the new_visitor.html template 
		return "new_visitor";
	}
	
	// add a visitor
	@PostMapping("/SaveVisitor")
	public String saveVisitor(@ModelAttribute("visitor") Visitor vis)
	//@ModelAttribute  binds the object called "vis" of request body from the POST request into the 
	//visitor parameter of the saveVisitor() method.
	{
		visitorService.saveVisitor(vis);
		
		// after save the employee data to database, redirect to "/"
		return "redirect:/ListOfVisitors";
	}
	
	//show update form
	@GetMapping("/showFormForUpdate/{id}")
	public String showUpdateForm(@PathVariable Long id, Model model)
	// @PathVariable binds the {id} which the path of the GET request contains into the id parameter of showUpdateForm() method.
	{
		Visitor vis = visitorService.getVisitorById(id);
		
		//We can use this attribute "visitor" to perform server-side rendering of the HTML with Thymeleaf.
		model.addAttribute("visitor",vis); 
		
		//show update_visitor.html template
		return "update_visitor";
	}
	
	// delete the visitor by id
	@GetMapping("/delete/{id}")
	public String deleteVisitorById(@PathVariable Long id, Model model)
	{
		visitorService.deleteVisitorById(id);
		
		return "redirect:/ListOfVisitors";
		
	}
	
	
	
}
