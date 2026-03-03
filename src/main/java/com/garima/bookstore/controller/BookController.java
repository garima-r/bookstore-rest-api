package com.garima.bookstore.controller;

import com.garima.bookstore.api.PagedResponse;
import com.garima.bookstore.dto.BookRequestDTO;
import com.garima.bookstore.dto.BookResponseDTO;
import com.garima.bookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


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
    public BookResponseDTO createBook(@Valid @RequestBody BookRequestDTO bookDTO){
        return bookService.createBook(bookDTO);
    }

    //GET ALL BOOKS
    @GetMapping
    public PagedResponse<BookResponseDTO> getAllBooks(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction){
        
        return bookService.getAllBooks(page, size, sortBy, direction);
    }

    //GET BOOK BY ID
    @GetMapping("/{id}")
    public BookResponseDTO getBookById(@PathVariable Long id){
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
    public BookResponseDTO updateBook(@PathVariable Long id, @Valid @RequestBody BookRequestDTO bookDTO){
        return bookService.updateBook(id, bookDTO);
    }
}
