package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer = service.GetById(id);
        return ResponseEntity.ok().body(customer);
    };

    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer request){
        Customer customer = service.save(request);
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customers = service.getAll();
        return ResponseEntity.ok().body(customers);
    };
}
