package com.mm.storerestapi.service;

import com.mm.storerestapi.model.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase makePurchase(Purchase purchase);
    List<Purchase> getAllPurchases();
    List<Purchase> purchasesByCustomer(long id);
    List<Purchase> purchasesByCustomerAndProduct(long customerId, long productId);
}
