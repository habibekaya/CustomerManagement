package com.example.demo.controller;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import enums.OrderTypes;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) { this.service = service; }

    @PostMapping("/customer/{customerId}")
    public Order createForCustomer(@PathVariable Long customerId, @RequestBody Order req) {
        return service.createForCustomer(customerId, req);
    }

    // Sipariş detay
    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/by-customer/{customerId}")
    public List<Order> listByCustomer(@PathVariable Long customerId) {
        return service.getAllByCustomer(customerId);
    }

    @GetMapping("/by-type")
    public List<Order> listByTypeAndDate(@RequestParam OrderTypes type,
                                         @RequestParam String from,
                                         @RequestParam String to) {
        return service.findByTypeAndDate(type, LocalDateTime.parse(from), LocalDateTime.parse(to));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
