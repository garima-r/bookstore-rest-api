package com.garima.bookstore.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class BookPatchDTO {
    @Size(min=1, message="Title cannot be empty") // Preventing empty string, but allowing null.
    private String title; 
    @Size(min=1, message="Author cannot be empty")
    private String author;
    @Positive(message="Price must be positive")
    private Double price;

    public BookPatchDTO(){}

    //Getters and Setters
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public Double getPrice(){
        return price;
    }
}
