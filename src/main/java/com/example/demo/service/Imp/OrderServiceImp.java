package com.example.demo.service.Imp;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import enums.OrderTypes;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;

    public OrderServiceImp(OrderRepository orderRepo, CustomerRepository customerRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public Order createForCustomer(Long customerId, Order req) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + customerId));
        req.setCustomer(customer);
        return orderRepo.save(req);
    }

    @Override
    @Transactional
    public Order getById(Long id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    @Override
    @Transactional
    public List<Order> getAllByCustomer(Long customerId) {
        return orderRepo.findByCustomerId(customerId);
    }

    @Override
    @Transactional
    public List<Order> findByTypeAndDate(OrderTypes type, LocalDateTime from, LocalDateTime to) {
        return orderRepo.findByOrderTypeAndCreatedAtBetween(type, from, to);
    }

    @Override
    public void delete(Long id) {
        orderRepo.delete(getById(id));
    }
}