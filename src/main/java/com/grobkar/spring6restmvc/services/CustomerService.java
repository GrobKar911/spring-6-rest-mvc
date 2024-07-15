package com.grobkar.spring6restmvc.services;

import com.grobkar.spring6restmvc.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<Customer> listAllCustomers();

    Optional<Customer> getCustomerById(UUID id);

    Customer newSavedCustomer(Customer customer);

    void updateCustomerById(UUID id, Customer customer);
    void deleteCustomerById(UUID customerId);

    void patchCustomerById(UUID id, Customer customer);
}
