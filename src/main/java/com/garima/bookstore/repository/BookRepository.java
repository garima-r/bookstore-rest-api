package com.garima.bookstore.repository;
import com.garima.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {}
