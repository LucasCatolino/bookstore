package com.cleancode.bookstore.customermanager;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
@JsonDeserialize(using = CustomerDeserializer.class)
public interface Customer {
    
    @Id
    public Long getId();
    public void setId(Long id);
    public String getName();
    public void setName(String name);
    public String getAddress();
    public void setAddress(String address);
    public String getType();
    public void setType(String type);

}
