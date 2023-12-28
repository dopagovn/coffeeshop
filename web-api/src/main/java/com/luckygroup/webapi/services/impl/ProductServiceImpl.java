package com.luckygroup.webapi.services.impl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckygroup.webapi.models.Product;
import com.luckygroup.webapi.repository.ProductRepository;
import com.luckygroup.webapi.services.ProductService;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    
    private final String uploadDir = "C:\\Users\\hoang\\Desktop\\ptpm\\coffeeshop\\ui\\public\\assets\\img";

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
    public Product saveProduct(Product product, MultipartFile productImage) throws IOException {
        
        String originalFilename  = productImage.getOriginalFilename(); //lay duong dan cua anh
        System.out.println(originalFilename);
        // Loại bỏ khoảng trắng và dấu từ tên tệp
        String sanitizedFilename = originalFilename.replaceAll("\\s+", "_"); // Thay thế khoảng trắng bằng dấu gạch dưới
        sanitizedFilename = sanitizedFilename.replaceAll("[^a-zA-Z0-9._-]", ""); // Loại bỏ các ký tự không hợp lệ
        String fileName = "coffe_"+ sanitizedFilename;
        Path filePath = Path.of(uploadDir, fileName);
        Files.copy(productImage.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);//thay the bang anh moi

        // Đặt tên hình ảnh cho đối tượng Product
        product.setProductImage(fileName);

        // Lưu đối tượng Product vào cơ sở dữ liệu
        return productRepository.save(product);
    }



  public Product deserializeProductFromJson(String productJson) {
    try {
        if (productJson != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(productJson, Product.class); // chhuyeenr tu json sang doi tuong product
        } else {
            // Xử lý trường hợp chuỗi JSON là null
            throw new IllegalArgumentException("JSON string is null");
        }
    } catch (JsonProcessingException e) {
        // Xử lý exception nếu có lỗi khi deserialization
        throw new RuntimeException("Failed to deserialize JSON to Product", e);
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






//put



@Override
public Product updateProduct(Long id, Product updatedProduct, MultipartFile productImage) throws IOException {
    Product existingProduct = findProductById(id);

    if (existingProduct == null) {
        throw new ResourceNotFoundException("Product not found");
    }

    try {
        // Xóa tệp hình ảnh cũ
        if (existingProduct.getProductImage() != null) {
            Path oldFilePath = Paths.get(uploadDir, existingProduct.getProductImage());
            Files.deleteIfExists(oldFilePath);
        }

        // Kiểm tra và tạo thư mục uploadDir nếu nó không tồn tại
        Path uploadDirPath = Paths.get(uploadDir);
        if (!Files.exists(uploadDirPath)) {
            Files.createDirectories(uploadDirPath);
        }

        String originalFilename = productImage.getOriginalFilename();
        String sanitizedFilename = originalFilename.replaceAll("\\s+", "_");
        sanitizedFilename = sanitizedFilename.replaceAll("[^a-zA-Z0-9._-]", "");
        String fileName = "coffe_" + sanitizedFilename;
        Path filePath = Paths.get(uploadDir, fileName);

        Files.copy(productImage.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Cập nhật thông tin sản phẩm
        existingProduct.setCategoryId(updatedProduct.getCategoryId());
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductDescription(updatedProduct.getProductDescription());
        existingProduct.setProductPrice(updatedProduct.getProductPrice());
        existingProduct.setProductImage(fileName);
        existingProduct.setStockQuantity(updatedProduct.getStockQuantity());

        
        return productRepository.save(existingProduct);
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to update product: " + e.getMessage(), e);
    }
}


}
