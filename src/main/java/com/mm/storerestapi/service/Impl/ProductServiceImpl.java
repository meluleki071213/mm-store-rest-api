package com.mm.storerestapi.service.Impl;

import com.mm.storerestapi.exception.ResourceNotFoundException;
import com.mm.storerestapi.model.Product;
import com.mm.storerestapi.repository.ProductRepository;
import com.mm.storerestapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        // 2. Products should not be duplicated.
        boolean productExists = productRepository.existsById(product.getId());
        if(productExists) {
            throw new RuntimeException("Duplicate product found for product " + product.getId());
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","Id", id));
    }

    @Override
    public Product updateProduct(Product product, long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","Id", id));

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        productRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));

        productRepository.deleteById(id);
    }
}
