package com.garima.bookstore.entity;
import jakarta.persistence.*;

@Entity
@Table(name="books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String title;
    private String author;
    private Double price;

    //Constructors
    public Book(){}

    public Book(String title, String author, Double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    //Getters and Setters
    public Long getId(){return id;}

    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }

    public String getAuthor(){ return author; }
    public void setAuthor(String author){ this.author = author; }

    public Double getPrice(){ return price; }
    public void setPrice(Double price){ this.price = price; }
    
}
