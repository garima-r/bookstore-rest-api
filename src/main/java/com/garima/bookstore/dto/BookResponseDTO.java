package com.garima.bookstore.dto;

public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private Double price;

    public BookResponseDTO(){}

    public BookResponseDTO(Long id, String title, String author, Double price){
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public Long getId(){
        return id;
    }

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
