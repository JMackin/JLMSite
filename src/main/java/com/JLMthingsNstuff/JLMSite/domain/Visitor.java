package com.JLMthingsNstuff.JLMSite.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//I'm guessing this is what might be referred to as the "model" (for a visitor) in MVC
@Entity
public class Visitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	By @GeneratedValue, JPA makes a unique key automatically and applies the key to the field having @Id
	private long id;
	private String firstName;
	private String lastName;
	private String quip;
	
	public Visitor()
	{
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirsName(String firsName) {
		this.firstName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getQuip() {
		return quip;
	}

	public void setQuip(String quip) {
		this.quip = quip;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Long getId()
	{
		return id;
	}
	
	

}
