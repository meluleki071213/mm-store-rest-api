package com.mm.storerestapi.repository;

import com.mm.storerestapi.model.Customer;
import com.mm.storerestapi.model.Product;
import com.mm.storerestapi.model.Purchase;
import org.springframework.boot.env.ConfigTreePropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
//    boolean existsByCustomerAndProduct(Customer customer, Product product);
    List<Purchase> findByCustomer_Id(long id);
    List<Purchase> findByCustomer_IdAndProduct_Id(long customerId, long productId);

    // TODO: Fix the query to get average expenditure per customer
//    @Query("Select AVG(price) from Product JOIN purchase ON customer_id = :id WHERE customer_id IN (Select customer_id From purchase)")
//    double getAvgByCustomerId(@Param("id") long id,@Param("startDate") LocalDate startDate ,@Param("endDate") LocalDate endDate);

}
// Join Purchase customer_id = Id AND Date BETWEEN :startDate AND :endDate