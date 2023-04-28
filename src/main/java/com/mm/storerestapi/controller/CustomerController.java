package com.mm.storerestapi.controller;

import com.mm.storerestapi.model.Customer;
import com.mm.storerestapi.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    // build create customer REST API
    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    // build get all customers REST API
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // build get customer by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id){
        return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
    }
    // build update customer REST API
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id), HttpStatus.OK);
    }

    // build delete customer REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
        // delete customer from DB
        customerService.deleteCustomer(id);
        return new ResponseEntity<String>("Customer deleted successfully!", HttpStatus.OK);
    }
}
