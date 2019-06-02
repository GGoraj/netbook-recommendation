package com.netbook.recommendation.book;

import java.util.List;

public class RecommendationResponse {

	private List<Book> recommendedBooks;

	public RecommendationResponse() {

	}

	public RecommendationResponse(List<Book> recommendedBooks) {
		this.recommendedBooks = recommendedBooks;
	}

	public List<Book> getRecommendedBooks() {
		return recommendedBooks;
	}

	public void setRecommendedBooks(List<Book> recommendedBooks) {
		this.recommendedBooks = recommendedBooks;
	}

}

