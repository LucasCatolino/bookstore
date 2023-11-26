package com.cleancode.bookstore.customermanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonDeserialize(as = Customer.class)
public class MinorCustomer implements Customer {    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerAddress;
    private String type;

    public MinorCustomer(String name, String address) {
        this.customerName = name;
        this.customerAddress = address;
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
        return "MINOR";
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

}
