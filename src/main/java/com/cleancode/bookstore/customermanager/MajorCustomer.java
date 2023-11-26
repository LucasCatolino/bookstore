package com.cleancode.bookstore.customermanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonDeserialize(as = Customer.class)
public class MajorCustomer implements Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String companyAddress;
    private String type;

    public MajorCustomer(String name, String address) {
        this.companyName = name;
        this.companyAddress = address;
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
        return "MAJOR";
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return companyName;
    }

    @Override
    public void setName(String name) {
        this.companyName = name;
    }

    @Override
    public String getAddress() {
        return this.companyAddress;
    }

    @Override
    public void setAddress(String address) {
        this.companyAddress = address;
    }

}
