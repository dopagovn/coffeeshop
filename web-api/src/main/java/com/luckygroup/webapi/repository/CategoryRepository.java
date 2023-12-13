package com.luckygroup.webapi.repository;

import com.luckygroup.webapi.models.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  Optional<Category> findById(Long id);
  Optional<Category> findByName(String name);
  Optional<Category> deleteById(int id);
}
