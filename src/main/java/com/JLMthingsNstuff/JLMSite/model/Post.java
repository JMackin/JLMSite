package com.JLMthingsNstuff.JLMSite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
//@Table(name = "BLOGPOSTS")
public class Post {
	
	private long id;
	private String postDateTime;
	private String postTitle;
	private String postContent;
	private String postAuthor;
	
	public Post()
	{
		
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

	public void setPostDateTime(LocalDateTime postDateTime) {
		
		final LocalDateTime ldt = LocalDateTime.now();
		final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String pdt = sdf.format(ldt);
		
		this.postDateTime = pdt;
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
