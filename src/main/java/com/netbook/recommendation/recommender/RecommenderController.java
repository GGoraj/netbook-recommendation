package com.netbook.recommendation.recommender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netbook.recommendation.book.*;
import com.netbook.recommendation.tag.*;
import com.netbook.recommendation.user.UserController;
import com.netbook.recommendation.user.UserService;

import com.netbook.recommendation.rating.Rating;

@RestController
public class RecommenderController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TagService tagService;
	
	UserController uCon = new UserController();
	
	@RequestMapping("/recommend/{id}")	
	public List<Book> sortedList(@PathVariable Integer userId){
		
		List<Book> allBooks = bookService.getAllBooks();
		
		//List<Book> ratedBooks = uCon.getUserRatings(userId);
		
		//ArrayList<Tag> likedTags = new ArrayList<Tag>();
		/*
		List<Rating> userRatings = userService.getRatingByUser(userId);
		
		for(int z = 0; z < userRatings.size(); z++) {
			
			if(userRatings.get(z).getRating() > 3.5) {
				
				for(int g = 0; g < allBooks.size();g++) {
					
					if(allBooks.get(g).getBookid() == userRatings.get(z).getBookId()) {
						ratedBooks.add(allBooks.get(g));
					}	
				}
				
			}
		}
		
		
		// TODO: likedBooks.sortByBestLiked (Maybe need to implement comparable)
		//likedBooks.sort();
		
			List<Tag> currentTags;
		
		for(int y = 0; y < ratedBooks.size();y++) {
			currentTags = ratedBooks.get(y).getTags();
			
			for (int z = 0; z < currentTags.size();z++){
			likedTags.add(currentTags.get(z));
			}
		}
		*/
		
		Collections.sort(allBooks);
		// likedTags.sortByMostOccuring;
		// likedTags.getTop3UniqueTags
		// Search for highest rated book with those 3 genres in the database
		
		return allBooks;
	}
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi! The recommender is ready!";
	}

}
