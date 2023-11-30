package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.models.Product;
import com.luckygroup.webapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/products")
    public ResponseEntity<?> getAllProducts() {
        Optional<List<Product>> products = productService.getAllProducts();
        if (products.isPresent()) {
            return ResponseEntity.ok(products.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Products not found");
        }
    }

    @GetMapping(path = "/product")
    public ResponseEntity<?> getProductById(int id) {
        Optional<Product> product = productService.getProductById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Product not found");
        }
    }

    @PostMapping(path = "/product")
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.ok("Product saved successfully");
    }

    @DeleteMapping(path = "/product")
    public ResponseEntity<String> deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    // Bổ sung các phương thức khác tại đây

    // Ví dụ:
    @GetMapping(path = "/products-by-category")
    public ResponseEntity<?> getProductsByCategoryId(int categoryId) {
        Optional<List<Product>> products = productService.getProductsByCategoryId(categoryId);
        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Products not found for the given category ID");
        }
    }
}
