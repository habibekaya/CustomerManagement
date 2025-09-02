package com.example.demo.service.Imp;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> getAll() {

        return repository.findAll();
    }

    @Override
    public Customer GetById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("id is null"));
    }

    @Override
    public Customer update(Customer customerRequest, Long id) {
        Customer customer=repository.findById(id).orElseThrow(()->new RuntimeException("id is null"));
        customer.setId(id);
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setEmail(customerRequest.getEmail());
        return repository.save(customer);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Customer save(Customer customerRequest) {
        return repository.save(customerRequest);
    }
}
