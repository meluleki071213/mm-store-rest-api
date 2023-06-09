package com.mm.storerestapi.controller;

import com.mm.storerestapi.model.Customer;
import com.mm.storerestapi.model.Purchase;
import com.mm.storerestapi.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }
    @PostMapping
    public ResponseEntity<Purchase> makePurchase(@RequestBody Purchase purchase) {
        return new ResponseEntity<Purchase>(purchaseService.makePurchase(purchase), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    // 3(a) Get number of purchases made by customer
    @GetMapping("/customer/{customer_id}")
    public int purchasesByCustomer(@PathVariable("customer_id") long customerId){
        return purchaseService.purchasesByCustomer(customerId);
    }
    @GetMapping("/customer/{customer_id}/product/{product_id}")
    public List<Purchase> purchasesByCustomerAndProduct(@PathVariable("customer_id") long customerId, @PathVariable("product_id") long productId){
        return purchaseService.purchasesByCustomerAndProduct(customerId, productId);
    }

    // 3(b) Get the average expenditure per customer in a given time frame
    @GetMapping("/{customer_id}/{startDate}/{endDate}")
    public double getAvgExpByCustomer(@PathVariable("customer_id") long customerId,
                                      @PathVariable("startDate") LocalDate startDate,
                                      @PathVariable("endDate") LocalDate endDate){
        return purchaseService.getAvgExpByCustomer(startDate, endDate, customerId);
    }
}
