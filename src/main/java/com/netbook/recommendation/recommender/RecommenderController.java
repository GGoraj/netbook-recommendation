package com.netbook.recommendation.recommender;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netbook.recommendation.book.Book;
import com.netbook.recommendation.book.BookService;
import com.netbook.recommendation.tag.Tag;
import com.netbook.recommendation.user.User;

@RestController
public class RecommenderController {

	@Autowired
	private BookService bookService;
	
	public RecommenderController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/recommend/{id}")	
	public List<Tag> sortedList(@PathVariable Integer userId, User user){
		//User user = userService.getUserById(userId);
		ArrayList<Book> likedBooks = new ArrayList<Book>();
		ArrayList<Tag> likedTags;
	
		// for(int i = 0; i> user.ratedBooks.length-1;i++)
		for(int i = 0; i < user.getRatedBooks().size();i++) {
			// IF user.ratedBooks[i].rating is bigger than 3.5/5 (or something) 
			if(user.getRatedBooks().get(i).getAverageRating().doubleValue() > 3.5){
				// likedBooks.add(User.ratedBooks[i])
				likedBooks.add(user.getRatedBooks().get(i));
			}
		}
		
		// TODO: likedBooks.sortByBestLiked (Maybe need to implement comparable)
		//likedBooks.sort();
		
		for(int y = 0; y < likedBooks.size();y++) {
			// likedGenres[].add(likedBooks[0].getGenres) && TODO: do it for top 3-5 instead of just most liked book?
			// OR
			//for (int z = 0; z < likedBooks.get(y).getGenres().size();z++){
			//likedGenres.add(likedBooks.get(y).getGenres().get(z));
			//}
		}
		
		// likedGenres.sortByMostOccuring
		// likedGenres.getTop3UniqueGneres
		
		// Search for highest rated book with those 3 genres in the database
		
		
		return null;
	}
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}

}
