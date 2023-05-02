package com.mm.storerestapi.service;

import com.mm.storerestapi.model.Purchase;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseService {
    Purchase makePurchase(Purchase purchase);
    List<Purchase> getAllPurchases();
    int purchasesByCustomer(long id);
    List<Purchase> purchasesByCustomerAndProduct(long customerId, long productId);

    //TODO: Fix the query on the Repository 1st
    double getAvgExpByCustomer(LocalDate startDate, LocalDate endDate, long id);
}
