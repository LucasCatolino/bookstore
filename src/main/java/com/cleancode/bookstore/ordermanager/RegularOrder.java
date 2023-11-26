package com.cleancode.bookstore.ordermanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonDeserialize(as = Order.class)
public class RegularOrder implements Order {    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerAddress;
    private int quantity;
    private String type;

    public RegularOrder(String name, String address, int quantity) {
        this.customerName = name;
        this.customerAddress = address;
        this.quantity = quantity;
    }

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
        return "REGULAR";
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return customerName;
    }

    @Override
    public void setName(String name) {
        this.customerName = name;
    }

    @Override
    public String getAddress() {
        return this.customerAddress;
    }

    @Override
    public void setAddress(String address) {
        this.customerAddress = address;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

}
