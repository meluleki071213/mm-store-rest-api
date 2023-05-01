package com.mm.storerestapi.service.Impl;

import com.mm.storerestapi.exception.ResourceNotFoundException;
import com.mm.storerestapi.model.Customer;
import com.mm.storerestapi.repository.CustomerRepository;
import com.mm.storerestapi.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @Override
    public Customer getCustomerById(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        } else {
            throw new ResourceNotFoundException("Customer","Id", id);
        }
//        return customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","Id", id));
    }

    @Override
    public Customer updateCustomer(Customer customer, long id) {
        // check whether customer with given id exists in DB or not
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));

        // update customer old values with new values
        existingCustomer.setName(customer.getName());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setDob(customer.getDob());

        // save new customer to DB
        customerRepository.save(existingCustomer);
        return existingCustomer;
    }

    @Override
    public void deleteCustomer(long id) {
        // check if customer exists in the DB or not
        customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));

        customerRepository.deleteById(id);
    }
}
