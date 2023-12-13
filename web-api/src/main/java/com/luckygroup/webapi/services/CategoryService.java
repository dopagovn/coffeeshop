package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Category;
import com.luckygroup.webapi.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService {

  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Optional<Category> getCategoryById(int categoryId) {
    return categoryRepository.findById(categoryId);
  }

  public Optional<List<Category>> getAllCategories() {
    List<Category> categories = categoryRepository.findAll();
    return Optional.ofNullable(categories);
  }

  public void saveCategory(Category category) {
    categoryRepository.save(category);
  }

  public void deleteCategory(int id) {
    categoryRepository.deleteById(id);
  }

  // Additional methods can be added here

  // Example:
  public Optional<Category> getCategoriesByName(String name) {
    return categoryRepository.findByName(name);
  }
}
