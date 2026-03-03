package com.garima.bookstore.controller;

import com.garima.bookstore.api.PagedResponse;
import com.garima.bookstore.dto.BookDTO;
import com.garima.bookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //CREATE BOOK
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@Valid @RequestBody BookDTO bookDTO){
        return bookService.createBook(bookDTO);
    }

    //GET ALL BOOKS
    @GetMapping
    public PagedResponse<BookDTO> getAllBooks(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction){
        
        return bookService.getAllBooks(page, size, sortBy, direction);
    }

    //GET BOOK BY ID
    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }
    
    //DELETE BOOK
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
       bookService.delete(id);
    }

    //UPDATE BOOK
    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO){
        return bookService.updateBook(id, bookDTO);
    }
}
