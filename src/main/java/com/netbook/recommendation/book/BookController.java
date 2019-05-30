package com.netbook.recommendation.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.netbook.recommendation.tag.Tag;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired BookService service;
    
    @GetMapping("/allbooks")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") Integer id){
        return service.getBookById(id);
    }
    
	@GetMapping("/bookTags/{id}")
	public List<Tag> getTagsByBookId(@PathVariable Integer id){
		List<Tag> bookTags;
		bookTags = service.getBookById(id).getTags();
		return bookTags;
	}
}