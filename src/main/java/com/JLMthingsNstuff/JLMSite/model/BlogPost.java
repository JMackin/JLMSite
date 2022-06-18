package com.JLMthingsNstuff.JLMSite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BLOGPOSTS")
public class BlogPost {
	
	private long id;
	private String postDateTime;
	private String postTitle;
	private String postContent;
	private String postAuthor;
	
	
	public BlogPost()
	{
	}
	
	public BlogPost(String pdt)
	{
		this.postDateTime = pdt;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPostDateTime() {
		
		return postDateTime;
	}

	public void setPostDateTime(String postDT) {
		
		this.postDateTime = postDT;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostAuthor() {
		return postAuthor;
	}

	public void setPostAuthor(String postAuthor) {
		this.postAuthor = postAuthor;
	}
	

}



