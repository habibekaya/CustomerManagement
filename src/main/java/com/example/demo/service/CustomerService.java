package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer GetById(Long id);
    Customer update (Customer customerRequest,Long id);
    void delete(Long id);
    Customer save(Customer customerRequest);
}
