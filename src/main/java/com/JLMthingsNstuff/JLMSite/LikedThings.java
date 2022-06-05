package com.JLMthingsNstuff.JLMSite;

public class LikedThings {
	
	private String likeDrinks;
	private String likeFoods;
	private String favePerson = "Gabby!";
	
	public LikedThings(String ld, String lf)
	{
		super();
		this.likeDrinks = ld;
		this.likeFoods = lf;;
		
	}
	
	public String getLikedDrinks()
	{
		return likeDrinks;
	}
	
	public String getLikedFoods()
	{
		return likeFoods;
	}
	
	public String getFavePerson()
	{
		return favePerson;
	}
	
	public void setLikedFoods(String lf)
	{
		this.likeFoods = lf;
	}

}
