package com.garima.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class BookRequestDTO {
    @NotBlank(message = "Title cannot be empty")
    @Size(min = 2, max =100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    @Size(min=2, max=100, message="Author must be between 2 and 100 characters")
    private String author;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    public BookRequestDTO(){}

    public BookRequestDTO(String title, String author, Double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    //Getters
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public Double getPrice(){
        return price;
    }

    //Setters
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPrice(Double price){
        this.price = price;
    }
}
