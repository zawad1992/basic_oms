package com.errorpoint.basic_oms.service;

import com.errorpoint.basic_oms.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Optional<Customer> getCustomerById(int id);
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(int id, Customer customer);
    void deleteCustomer(int id);
}
