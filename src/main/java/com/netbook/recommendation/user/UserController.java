package com.netbook.recommendation.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netbook.recommendation.book.Book;
import com.netbook.recommendation.book.BookService;
import com.netbook.recommendation.rating.Rating;


@RestController
public class UserController {

	 @Autowired UserService service;
	    
	    @GetMapping("/users")
	    public List<User> getAllUsers(){
	        return service.getAllUsers();
	    }

	    @GetMapping("/user/{id}")
	    public User getUserById(@PathVariable("id") Integer id){
	        return service.getUserById(id);
	    }
	    
	    @GetMapping("/userrated/{id}")
	    public List<Book> getAllRatedBooks(@PathVariable Integer id){
	    	User user = service.getUserById(id);
	    	List<Rating> ratings = user.getRatings();
			List<Book> ratedBooks = new ArrayList<Book>();
			BookService bs = new BookService();
			for(int i = 0; i < ratings.size();i++) {
				ratedBooks.add(bs.getBookById(ratings.get(i).getBookId()));
			}
			return ratedBooks;
	    }
}
