package com.netbook.recommendation.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

	@Autowired
	TagService tagService;
	
	/*
	@GetMapping("/tags/{userID}")
	public List<Tag> getTagsByBookId(@PathVariable Integer userID){
		List<Tag> bookTags;
		//TODO: bookTags = dbConnection.selectAllTagsFromBookId(id);
		bookTags = new ArrayList<Tag>();	
		return bookTags;
	}*/

	@GetMapping("/tags/")
	public List<Tag> getAllTags(){
		return this.tagService.tagRepository.findAll();
	}
	
	
}
