package com.netbook.recommendation.rating;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Embeddable
@Table(name="ratings")
public class RatingID implements Serializable{
	
	@NotNull
	@Column(name= "user_id")
	Integer userId;
	
	@NotNull
	@Column(name= "book_id")
	Integer bookId;
	
	public RatingID() {}
	
	public RatingID(@NotNull Integer userId, @NotNull Integer bookId) {
		this.userId = userId;
		this.bookId = bookId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	@Override
	public String toString() {
		return "HELLOOOOOOOOO";
	}
}
