package com.netbook.recommendation.tag;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.netbook.recommendation.book.Book;

@Entity
@Table(name = "tags")
public class Tag implements Comparable<Tag>{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
    @Column(name="tagname")
	private String tagName;
    
    @ManyToMany(targetEntity=Book.class, fetch = FetchType.EAGER)
    private List<Book> books;
	
	public Integer getTagId() {
		return id;
	}

	public void setTagId(Integer id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	@Override
	public int compareTo(Tag tag) {
		if(this.id == tag.id) {
			return 0;
		}else if(this.id != tag.id){
			return -1;
		}else {
			throw new ArithmeticException("error message");		
		}
	}
	
}
