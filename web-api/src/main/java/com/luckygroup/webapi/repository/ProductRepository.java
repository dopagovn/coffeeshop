package com.luckygroup.webapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckygroup.webapi.models.OrderDetail;
import com.luckygroup.webapi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(int id);
    List<Product> findByCategoryId(int categoryId);
    Optional<Product> deleteById(int id);

    // List<Product> findByCategoryId(int categoryId); 
    // void deleteById(int id);
}
