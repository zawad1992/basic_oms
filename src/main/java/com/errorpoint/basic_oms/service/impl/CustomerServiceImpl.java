package com.errorpoint.basic_oms.service.impl;

import com.errorpoint.basic_oms.model.Customer;
import com.errorpoint.basic_oms.repository.CustomerRepository;
import com.errorpoint.basic_oms.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(int id, Customer customerDetails) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
        customerToUpdate.setName(customerDetails.getName());
        customerToUpdate.setEmail(customerDetails.getEmail());

        return customerRepository.save(customerToUpdate);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
