package com.firetech.blackghost.services;

import java.util.List;

import com.firetech.blackghost.model.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    void updateCustomer(Customer customer);
}
