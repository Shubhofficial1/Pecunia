package com.capgemini.pecuniabootcamp.service;

import com.capgemini.pecuniabootcamp.model.CustomerModel;

import java.util.List;

public interface CustomerService {
    CustomerModel createCustomer(CustomerModel customer);
    CustomerModel updateCustomer(CustomerModel customer);
    List<CustomerModel> getAllCustomers();
    CustomerModel getCustomerById(long id);
    void deleteCustomer(long id);


}
