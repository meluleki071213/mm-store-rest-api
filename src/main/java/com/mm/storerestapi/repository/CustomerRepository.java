package com.mm.storerestapi.repository;

import com.mm.storerestapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsById(long id);
}
