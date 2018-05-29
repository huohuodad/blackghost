package com.firetech.blackghost.impl;

import java.util.ArrayList;
import java.util.List;

import com.firetech.blackghost.model.Customer;
import com.firetech.blackghost.services.CustomerService;

public class CustomerServiceMockImpl implements CustomerService {

    private static List<Customer> customers = new ArrayList<>();
    
    private volatile int idGen = 7001;
    
    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer createCustomer(Customer customer) {
        customer.setCustomerId(idGen++);
        customers.add(customer);
        return customer;
    }

    public void updateCustomer(Customer customer) {
        Customer d = customers.stream()
                .filter(x -> x.getCustomerId() == customer.getCustomerId())
                .findFirst()
                .get();
        if (d != null) {
            d.setCustomerId(customer.getCustomerId());
            d.setName(customer.getName());
            d.setMobile(customer.getMobile());
            d.setTelephone(customer.getTelephone());
            d.setWechatName(customer.getWechatName());
        }
    }

}
