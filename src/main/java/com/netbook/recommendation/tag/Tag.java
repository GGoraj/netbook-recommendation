package com.netbook.recommendation.tag;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.netbook.recommendation.book.Book;

@Entity
@Table(name = "tags")
public class Tag {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tagId;
	
    @Column(name="tagname")
	private String tagName;
    
    @ManyToMany(targetEntity=Book.class)
    private List<Book> books;
	
	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
}
