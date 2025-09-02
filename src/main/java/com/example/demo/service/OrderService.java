package com.example.demo.service;

import com.example.demo.model.Order;
import enums.OrderTypes;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    Order createForCustomer(Long customerId, Order req);
    Order getById(Long id);
    List<Order> getAllByCustomer(Long customerId);
    List<Order> findByTypeAndDate(OrderTypes type, LocalDateTime from, LocalDateTime to);
    void delete(Long id);}
