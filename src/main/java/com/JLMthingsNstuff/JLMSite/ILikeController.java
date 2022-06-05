package com.JLMthingsNstuff.JLMSite;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ILikeController {

	@GetMapping("/ThingsILike/")
	public List<LikedThings> getLikedThings()
	{
		List<LikedThings> lts = new ArrayList<>();
		
		lts.add(new LikedThings("Tea","Corn"));
		lts.add(new LikedThings("Water","Granola"));
		lts.add(new LikedThings("Coffee","Bread"));
		lts.add(new LikedThings("Juice","Cake"));
		
		return lts;
	}
	
	@GetMapping("/ThingsILike/{otherFIL}/{otherDIL}")
	public LikedThings newStuffILike(@PathVariable("otherFIL") String newFIL, @PathVariable("otherDIL") String newDIL)
	{
		return new LikedThings(newDIL,newFIL);
	}
	
	//query parameters
	//http://localhost:8080/ThingsILike/query?LikedFoods=Food&LikedDrinks=Drink
	@GetMapping("/ThingsILike/query")
	public LikedThings ltQueryParam(
			@RequestParam(name = "LikedFoods") String lf,
			@RequestParam(name = "LikedDrinks") String ld)
	{
		return new LikedThings(ld,lf);
	}
	

}
