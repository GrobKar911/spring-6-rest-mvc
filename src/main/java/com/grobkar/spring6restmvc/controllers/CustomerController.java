package com.grobkar.spring6restmvc.controllers;

import com.grobkar.spring6restmvc.model.Customer;
import com.grobkar.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer){
        Customer savedCustomer = customerService.newSavedCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/customer/" + savedCustomer.getCustomerId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers(){
        return customerService.listAllCustomers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") UUID id) {

        log.debug("Customer Controller - get by Id - 1234");

        return customerService.getCustomerById(id);
    }

}
