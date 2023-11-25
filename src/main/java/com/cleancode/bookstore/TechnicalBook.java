/*package com.cleancode.bookstore;

import jakarta.persistence.Entity;

import java.util.logging.Logger;

@Entity
public class TechnicalBook extends Book {
    private static final Logger LOGGER = Logger.getLogger(Novel.class.getName());

    public TechnicalBook(String title, String author, int year) {
        super.setTitle(title);
        super.setAuthor(author);
        super.setYear(year);
        super.setType("technical");

        // Log statement in the constructor
        LOGGER.info("Technical book created: " + title + " by " + author + " year " + year);
    }
}
*/