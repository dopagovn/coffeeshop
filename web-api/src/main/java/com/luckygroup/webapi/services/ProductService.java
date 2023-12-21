package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product findProductById(Long id);
    List<Product> getAllProducts();
    
    // Product saveProduct(Product product);
    void deleteProduct(Long id);
    Product deserializeProductFromJson(String productJson);
    Product saveProduct(Product product, MultipartFile multipartFile) throws IOException;

    // Bổ sung các phương thức tùy chỉnh nếu cần
}

