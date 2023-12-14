package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Product;
import java.util.List;

public interface ProductService {
    Product findProductById(Long id);
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    void deleteProduct(Long id);

    // Bổ sung các phương thức tùy chỉnh nếu cần
}
