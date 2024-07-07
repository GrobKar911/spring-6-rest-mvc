package com.grobkar.spring6restmvc.controllers;

import com.grobkar.spring6restmvc.model.Customer;
import com.grobkar.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers(){
        return customerService.listAllCustomers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") UUID id) {

        log.debug("Customer Controller - get by Id " + id.toString());

        return customerService.getCustomerById(id);
    }

}
