package com.mm.storerestapi.repository;

import com.mm.storerestapi.model.Customer;
import com.mm.storerestapi.model.Product;
import com.mm.storerestapi.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
//    boolean existsByCustomerAndProduct(Customer customer, Product product);
    List<Purchase> findByCustomer_Id(long id);
    List<Purchase> findByCustomer_IdAndProduct_Id(long customerId, long productId);
}
