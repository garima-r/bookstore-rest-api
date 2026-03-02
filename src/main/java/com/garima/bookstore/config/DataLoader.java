package com.garima.bookstore.config;
import com.garima.bookstore.entity.Book;
import com.garima.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    private final BookRepository bookRepository;

    DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Bean
    CommandLineRunner loadData(BookRepository bookRepository){
        return  args -> {
            Book book1 = new Book("Clean Code", "Robert C. Martin", 499.0);
            Book book2 = new Book("Effective Java", "Joshua Bloch", 599.0);

            bookRepository.save(book1);
            bookRepository.save(book2);

            System.out.println("Sample books inserted!");
        };
    }
}
