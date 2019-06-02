package com.netbook.recommendation.rating;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

	@Autowired RatingService service;
	    
	@GetMapping("/ratings")
    public List<Rating> getAllRatings(){
        return service.getAllRatings();
    }
    
	@GetMapping("/ratings/{id}")
    public List<Rating> getRatingsByUser(@PathVariable Integer id){
		List<Rating> unrated = service.repository.findAll();
		List<Rating> rated = new ArrayList<Rating>();
		for(int i = 0; i < unrated.size();i++) {
			if(unrated.get(i).userId == id) {
				rated.add(unrated.get(i));
			}
		}
        
		return rated; 
    }
    
    

}
