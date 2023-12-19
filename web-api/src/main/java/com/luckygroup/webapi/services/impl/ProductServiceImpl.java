package com.luckygroup.webapi.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckygroup.webapi.models.Product;
import com.luckygroup.webapi.repository.ProductRepository;
import com.luckygroup.webapi.services.ProductService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
  public Product saveProduct(Product product, MultipartFile productImage)
    throws IOException {
    // Lưu trữ tệp hình ảnh trong thư mục cụ thể
    String uploadDir =
      "/Users/thisisquocthinh/Workspace/coffeeshop/ui/public/assets/img/";

    String originalFilename = productImage.getOriginalFilename();
    // Loại bỏ khoảng trắng và dấu từ tên tệp
    String sanitizedFilename = originalFilename.replaceAll("\\s+", "_"); // Thay thế khoảng trắng bằng dấu gạch dưới
    sanitizedFilename = sanitizedFilename.replaceAll("[^a-zA-Z0-9._-]", ""); // Loại bỏ các ký tự không hợp lệ
    String fileName = "coffe_" + sanitizedFilename;
    Path filePath = Path.of(uploadDir, fileName);

    Files.copy(
      productImage.getInputStream(),
      filePath,
      StandardCopyOption.REPLACE_EXISTING
    );

    // Đặt tên hình ảnh cho đối tượng Product
    product.setProductImage(fileName);

    // Lưu đối tượng Product vào cơ sở dữ liệu
    return productRepository.save(product);
  }

  //  @Override
  // public Product saveProduct(Product product, MultipartFile imageFile) throws IOException {
  //     // Lưu trữ tệp hình ảnh trong thư mục cụ thể (hoặc thư mục bạn chọn)
  //     String uploadDir = "path/to/your/image/folder";
  //     String fileName = imageFile.getOriginalFilename();
  //     Path filePath = Path.of(uploadDir, fileName);

  //     Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

  //     // Đặt tên hình ảnh cho đối tượng Product
  //     product.setImageFileName(fileName);

  //     // Lưu đối tượng Product vào cơ sở dữ liệu
  //     return productRepository.save(product);
  // }
  // Trong ProductService
  public Product deserializeProductFromJson(String productJson) {
    try {
      if (productJson != null) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(productJson, Product.class);
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
}
