package com.mm.storerestapi.repository;

import com.mm.storerestapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsById(long id);


}
