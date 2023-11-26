package com.cleancode.bookstore.ordermanager;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
@JsonDeserialize(using = OrderDeserializer.class)
public /*abstract*/ interface Order { //TODO: volverlo abstract
    
    @Id
    public Long getId();
    public void setId(Long id);
    public String getName();
    public void setQuantity(int quantity);
    public int getQuantity();
    public void setName(String name);
    public String getAddress();
    public void setAddress(String address);
    public String getType();
    public void setType(String type);

}
