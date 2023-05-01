package com.mm.storerestapi.service;

import com.mm.storerestapi.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(long id);
    Product updateProduct(Product product, long id);
    void deleteProduct(long id);
}
