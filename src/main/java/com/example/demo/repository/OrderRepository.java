package com.example.demo.repository;

import com.example.demo.model.Order;
import enums.OrderTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByOrderTypeAndCreatedAtBetween(OrderTypes type,
                                                   LocalDateTime from,
                                                   LocalDateTime to);
}
