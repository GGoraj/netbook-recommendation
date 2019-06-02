package com.netbook.recommendation.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netbook.recommendation.rating.Rating;

@Service
public class UserService {


    @Autowired
    UserRepository repository;
    
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	public User getUserById(Integer id) {
		return repository.findById(id).get();
	}
	
	
	public List<Rating> getRatingByUser(Integer id) {
		return repository.findById(id).get().getRatings();
	}
	
	
}
