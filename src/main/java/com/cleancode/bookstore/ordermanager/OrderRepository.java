package com.cleancode.bookstore.ordermanager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can add custom query methods here if needed
}
