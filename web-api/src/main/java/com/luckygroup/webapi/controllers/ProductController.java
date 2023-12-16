package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Product;
import com.luckygroup.webapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

import java.io.IOException;


@Controller
@RequestMapping(path = "/api/v1")
public class ProductController {

    private final ProductService productService;

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
                    product);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed",
                    null);
        }
    }

    @GetMapping(path = "/products")
    public ResponseEntity<Object> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Successful",
                    products);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed",
                    null);
        }
    }

  
    //                 HttpStatus.OK,
    //                 "Product saved successfully",
    //                 savedProduct);
    //     } catch (Exception e) {
    //         return ResponseHandler.generateResponse(
    //                 HttpStatus.INTERNAL_SERVER_ERROR,
    //                 "Cannot save product",
    //                 null);
    //     }
    // }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Product deleted successfully",
                    null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Cannot delete product",
                    null);
        }
    }

      // @PostMapping("/product")
    // public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
    // try {
    // Product savedProduct = productService.saveProduct(product);
    // return ResponseHandler.generateResponse(
    // HttpStatus.OK,
    // "Product saved successfully",
    // savedProduct
    // );
    // } catch (Exception e) {
    // return ResponseHandler.generateResponse(
    // HttpStatus.INTERNAL_SERVER_ERROR,
    // "Cannot save product",
    // null
    // );
    // }
    // }

    // @PostMapping("/product")
    // public ResponseEntity<Object> saveProduct(
    //         @RequestParam("file") MultipartFile file,
    //         @RequestParam("product") String productJson) {
    //     try {
    //         // Lưu trữ tệp hình ảnh trong thư mục cụ thể (hoặc thư mục bạn chọn)
    //         String uploadDir = "C:\\Users\\hoang\\Desktop\\ptpm\\coffeeshop\\ui\\public\\assets\\img";
    //         String fileName = file.getOriginalFilename();
    //         Path filePath = Path.of(uploadDir, fileName);
    //         Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

    //         // Tạo đối tượng Product từ JSON bằng cách sử dụng ProductService
    //         Product product = productService.deserializeProductFromJson(productJson);

    //         // Đặt tên hình ảnh cho đối tượng Product
    //         product.setImageFileName(fileName);

    //         // Lưu đối tượng Product vào cơ sở dữ liệu
    //         Product savedProduct = productService.saveProduct(product, file);

    //         return ResponseHandler.generateResponse(

    @PostMapping("/product")
    public ResponseEntity<Object> handleImageUpload(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("productJson") String productJson) {
        try {
            // Deserialize chuỗi JSON thành đối tượng Product
            Product product = productService.deserializeProductFromJson(productJson);

            // Lưu thông tin sản phẩm và tên tệp ảnh vào cơ sở dữ liệu
            Product savedProduct = productService.saveProduct(product, file);

            return ResponseEntity.ok(savedProduct);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to process image upload: " + e.getMessage());
        }
    }
    

}
