package com.luckygroup.webapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckygroup.webapi.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(int id);
    Optional<Category> findByName( String name);
    Optional<Category> deleteById(int id);
}
