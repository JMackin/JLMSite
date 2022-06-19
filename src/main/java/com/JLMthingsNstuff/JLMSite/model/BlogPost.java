package com.JLMthingsNstuff.JLMSite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BLOGPOSTS")
public class BlogPost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "uname", nullable=false, length=16)
	private String uname;
	
	@Column(name = "post_content")
	private String postContent;
	
	@Column(name="post_date_time")
	private String postDateTime;
	
	@Column(name="post_title")
	private String postTitle;
	
	
	public BlogPost()
	{
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	

}



