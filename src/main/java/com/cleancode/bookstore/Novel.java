package com.cleancode.bookstore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.websocket.OnError;

import java.util.logging.Logger;

@Entity
public class Novel implements Book {    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int year;
    private String type;

    public Novel(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Implement the methods from the Book interface
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getType() {
        return "NOVEL";
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    /*
    private static final Logger LOGGER = Logger.getLogger(Novel.class.getName());

    public Novel(String title, String author, int year) {
        super.setTitle(title);
        super.setAuthor(author);
        super.setYear(year);
        super.setType("novel");

        // Log statement in the constructor
        LOGGER.info("Novel created: " + title + " by " + author + " year " + year);
    }
*/

}
