package com.cleancode.bookstore.ordermanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonDeserialize(as = Order.class)
public class BulkOrder implements Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String companyAddress;
    private int quantity;
    private String type;

    public BulkOrder(String name, String address, int quantity) {
        this.companyName = name;
        this.companyAddress = address;
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
        return "BULK";
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

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

}
