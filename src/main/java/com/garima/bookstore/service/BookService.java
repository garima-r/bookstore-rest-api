package com.garima.bookstore.service;

import com.garima.bookstore.api.PagedResponse;
import com.garima.bookstore.dto.BookDTO;
import com.garima.bookstore.entity.Book;
import com.garima.bookstore.exception.ResourceNotFoundException;
import com.garima.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class BookService {
    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookDTO createBook(BookDTO bookDTO){
        log.info("Creating new book with title: {}", bookDTO.getTitle());

        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());

        Book savedBook = bookRepository.save(book);
        return convertToDTO(savedBook);
    }

    public PagedResponse<BookDTO> getAllBooks(int page, int size, String sortBy, String direction){
        Sort sort = direction.equalsIgnoreCase("desc")
                    ? Sort.by(sortBy).descending()
                    : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Book> bookPage = bookRepository.findAll(pageable);

        List<BookDTO> dtoList = bookPage.map(this::convertToDTO).getContent();


        return new PagedResponse<>(
            dtoList,
            bookPage.getNumber(),
            bookPage.getSize(),
            bookPage.getTotalElements(),
            bookPage.getTotalPages(),
            bookPage.isLast()
        );
    }

    //Read One
    public BookDTO getBookById(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Book not found"));
        return convertToDTO(book);        
    }

    //Delete
    public void delete(Long id){
        if(!bookRepository.existsById(id)){
            throw new ResourceNotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
    }

    //Update
    public BookDTO updateBook(Long id, BookDTO updatedBookDTO){
        Book existingBook = bookRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        
        existingBook.setTitle(updatedBookDTO.getTitle());
        existingBook.setAuthor(updatedBookDTO.getAuthor());  
        existingBook.setPrice(updatedBookDTO.getPrice());

        Book savedBook = bookRepository.save(existingBook);

        return convertToDTO(savedBook);
    }

    private BookDTO convertToDTO(Book book){
        return new BookDTO(
            book.getTitle(),
            book.getAuthor(),
            book.getPrice()
        );
    }
}