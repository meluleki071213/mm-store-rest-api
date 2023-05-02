package com.mm.storerestapi.service.Impl;

import com.mm.storerestapi.exception.ResourceNotFoundException;
import com.mm.storerestapi.model.Customer;
import com.mm.storerestapi.model.Product;
import com.mm.storerestapi.model.Purchase;
import com.mm.storerestapi.repository.CustomerRepository;
import com.mm.storerestapi.repository.ProductRepository;
import com.mm.storerestapi.repository.PurchaseRepository;
import com.mm.storerestapi.service.PurchaseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        super();
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Purchase makePurchase(Purchase purchase) {
        // check if customer exists in DB
        customerRepository.findById(purchase.getCustomer().getId()).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", purchase.getCustomer().getId()));
        // check if the product exists in the DB
        Product product = productRepository.findById(purchase.getProduct().getId()).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", purchase.getProduct().getId()));

        // 1. If there are no products in stock, a sale cannot occur.
        if (product.getQuantity() <= purchase.getUnitsBought()) {
            throw new RuntimeException("There are no products in stock");
        }

        // 4. Identify duplicate purchases and prevent them from occurring.
        // check if a purchase is a duplicate or not
//        boolean purchaseExists = purchaseRepository.existsByCustomerAndProduct(purchase.getCustomer(), purchase.getProduct());

//        if (purchaseExists) {
//            throw new RuntimeException("Duplicate purchase found for customer " + purchase.getCustomer().getId() + " and product " + purchase.getProduct().getId());
//        }

        // save a purchase to DB
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public List<Purchase> purchasesByCustomer(long id) {
        return purchaseRepository.findByCustomer_Id(id);
    }

    @Override
    public List<Purchase> purchasesByCustomerAndProduct(long customerId, long productId) {
        return purchaseRepository.findByCustomer_IdAndProduct_Id(customerId, productId);
    }
}
