package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Product;
import com.luckygroup.webapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(path = "/api/v1")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        try {
            Product product = productService.findProductById(id);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Successful",
                    product
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed",
                    null
            );
        }
    }

    @GetMapping(path = "/products")
    public ResponseEntity<Object> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Successful",
                    products
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed",
                    null
            );
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        try {
            Product savedProduct = productService.saveProduct(product);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Product saved successfully",
                    savedProduct
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Cannot save product",
                    null
            );
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Product deleted successfully",
                    null
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Cannot delete product",
                    null
            );
        }
    }

    // Bổ sung các phương thức khác tại đây

    // Ví dụ:
//     @GetMapping(path = "/products-by-category/{categoryId}")
//     public ResponseEntity<Object> getProductsByCategoryId(@PathVariable Long categoryId) {
//         try {
//             List<Product> products = productService.getProductsByCategoryId(categoryId);
//             return ResponseHandler.generateResponse(
//                     HttpStatus.OK,
//                     "Successful",
//                     products
//             );
//         } catch (Exception e) {
//             return ResponseHandler.generateResponse(
//                     HttpStatus.INTERNAL_SERVER_ERROR,
//                     "Failed",
//                     null
//             );
//         }
//     }
}
