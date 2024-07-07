package com.grobkar.spring6restmvc.services;

import com.grobkar.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    Map<UUID,Customer> customerMap = new HashMap();

    CustomerServiceImpl() {

        Customer customer1 = Customer.builder()
                .customerName("John Thomson")
                .customerId(UUID.randomUUID())
                .version(123)
                .createdDate(LocalDateTime.now())
                .lastModifyDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .customerName("Kamil Stoch")
                .customerId(UUID.randomUUID())
                .version(123)
                .createdDate(LocalDateTime.now())
                .lastModifyDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .customerName("Chuck Norris")
                .customerId(UUID.randomUUID())
                .version(123)
                .createdDate(LocalDateTime.now())
                .lastModifyDate(LocalDateTime.now())
                .build();


        customerMap.put(customer1.getCustomerId(),customer1);
        customerMap.put(customer2.getCustomerId(),customer2);
        customerMap.put(customer3.getCustomerId(),customer3);

    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {

        log.debug("Get Customer by Id : " + id.toString());
        return customerMap.get(id);
    }

    @Override
    public Customer newSavedCustomer(Customer customer) {
        Customer savedCustomer = Customer.builder()
                .customerId(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifyDate(LocalDateTime.now())
                .build();

        customerMap.put(savedCustomer.getCustomerId(),savedCustomer);

        return savedCustomer;
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(UUID id, Customer customer) {
        Customer existingCustomer = customerMap.get(id);
        if(StringUtils.hasText(customer.getCustomerName())){
            existingCustomer.setCustomerName(customer.getCustomerName());
        }
    }

    @Override
    public void updateCustomerById(UUID id, Customer customer) {
        Customer existingCustomer = customerMap.get(id);
        existingCustomer.setCustomerName(customer.getCustomerName());
    }
}
