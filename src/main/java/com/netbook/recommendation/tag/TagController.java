package com.netbook.recommendation.tag;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

	@Autowired
	TagService tagService;
	
	@GetMapping("/tags/{userID}")
	public List<Tag> getTagsByBookId(@PathVariable Integer userID){
		List<Tag> bookTags;
		//bookTags = tagService.tagRepository
		bookTags = new ArrayList<Tag>();	
		return bookTags;
	}

	@GetMapping("/tags/")
	public List<Tag> getAllTags(){
		return tagService.tagRepository.findAll();
	}
	
	
}
