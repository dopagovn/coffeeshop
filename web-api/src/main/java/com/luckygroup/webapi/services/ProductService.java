package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Product;
import com.luckygroup.webapi.repository.ProductRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(int productId) {
        return productRepository.findById(productId);
    }

    public Optional<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return Optional.ofNullable(products);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }


    public Optional<List<Product>> getProductsByCategoryId(int categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return Optional.ofNullable(products);
    }
}
