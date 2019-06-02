package com.netbook.recommendation.rating;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.netbook.recommendation.user.User;

@Entity
@Table(name="ratings")
public class Rating {
	
    @EmbeddedId
    @Autowired
    private RatingID iD;
	
	@NotNull
	@Column(name= "user_id", insertable=false, updatable=false)
	Integer userId;
	
	@NotNull
	@Column(name= "book_id", insertable=false, updatable=false)
	Integer bookId;
	
	@Column(name= "rating")
	double rating;

	@ManyToMany(targetEntity= User.class,mappedBy = "")
    private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	

}
