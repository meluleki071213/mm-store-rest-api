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

    boolean existsByCustomerAndProduct(Customer customer, Product product);
    @Query("SELECT AVG(p.unitsBought * p.product.price) " +
            "FROM Purchase p " +
            "JOIN p.product pr " +
            "WHERE p.customer.id = :customerId " +
            "AND p.date BETWEEN :startDate AND :endDate")
    double findAvgExpByCustomer_IdAndDate(@Param("startDate") LocalDate startDate,
                                                  @Param("endDate") LocalDate endDate,
                                                  @Param("customerId") long customerId);
}
