package com.netbook.recommendation.rating;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RatingService {

	@Autowired
    RatingRepository repository;
	
	public List<Rating> getAllRatings(){
		return repository.findAll();
	}
	
}
