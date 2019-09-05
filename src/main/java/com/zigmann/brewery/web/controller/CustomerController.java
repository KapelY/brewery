package com.zigmann.brewery.web.controller;

import com.sun.net.httpserver.Headers;
import com.zigmann.brewery.services.CustomerService;
import com.zigmann.brewery.web.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> gerCustomer(@PathVariable("customerId")UUID id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
        CustomerDto saveCustomer = customerService.saveNewCustomer(customerDto);

        Headers headers = new Headers();

        headers.add("Location", "/api/v1/customer/" + saveCustomer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID customerId) {
        customerService.deleteCustomer(customerId);
    }
}
