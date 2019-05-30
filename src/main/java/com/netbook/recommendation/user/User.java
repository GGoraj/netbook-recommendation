package com.netbook.recommendation.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.netbook.recommendation.book.Book;

public class User {
	String firstName;
	String lastName;
	String email;
	String password;
	int ID;
	HashMap<Book, Double> ratings;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Book> getRatedBooks() {
		
		return null;
	}
	
	/*
	public void setRatings() {
		HashMap<Book, Double> dbRatings = new HashMap<Book, Double>();
		//TODO: get all the books that this user has rated
		this.ratings = dbRatings;
	}
	*/
}
