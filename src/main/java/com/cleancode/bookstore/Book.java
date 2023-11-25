package com.cleancode.bookstore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public /*abstract*/ interface Book { //TODO: volverlo abstract
    
    @Id
    public Long getId();
    public void setId(Long id);
    public String getTitle();
    public void setTitle(String title);
    public String getAuthor();
    public void setAuthor(String author);
    public int getYear();
    public void setYear(int year);
    public String getType();
    public void setType(String type);

/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int year;
    private String type; // Added field for book type

    // Factory method to create different types of books
    public static Book createBook(String type, String title, String author, int year) {
        switch (type.toLowerCase()) {
            case "novel":
                return new Novel(title, author, year);
            case "technical":
                return new TechnicalBook(title, author, year);
            // Add more types as needed
            default:
                throw new IllegalArgumentException("Invalid book type: " + type);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
*/
}
