package com.netbook.recommendation.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	Object dbConnection;
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public List<User> getAllUsers(){
		List<User> users;
		
		//TODO: users = dbConnection.selectAll();
		
		//temp:
		users = new ArrayList<User>();
		
		return users;
	}
	
}
