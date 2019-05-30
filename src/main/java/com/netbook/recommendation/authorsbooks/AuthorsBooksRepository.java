package com.netbook.recommendation.authorsbooks;

import com.netbook.recommendation.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsBooksRepository extends JpaRepository<Book, Integer> {


}
