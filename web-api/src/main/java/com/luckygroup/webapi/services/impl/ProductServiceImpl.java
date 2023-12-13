package com.luckygroup.webapi.services.impl;
import com.luckygroup.webapi.models.Product;
import com.luckygroup.webapi.repository.ProductRepository;
import com.luckygroup.webapi.services.ProductService;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(Long id) {
        try {
            Optional<Product> product = productRepository.findById(id);
            return product.orElse(null);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found product", e);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();
            return products;
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found product", e);
        }
    }

    @Override
    public Product saveProduct(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Failed to save product", e);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Failed to delete product", e);
        }
    }
    
}
