package com.cleancode.bookstore.bookmanager;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
@JsonDeserialize(using = BookDeserializer.class)
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

}
