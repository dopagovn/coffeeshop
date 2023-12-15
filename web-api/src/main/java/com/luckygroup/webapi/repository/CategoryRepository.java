package com.luckygroup.webapi.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  Optional<Category> findById(int id);
  List<Category> findByName(String name);
  Optional<Category> deleteById(int id);
}
