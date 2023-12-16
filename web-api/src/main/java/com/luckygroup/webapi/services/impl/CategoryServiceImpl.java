package com.luckygroup.webapi.services.impl;

import com.luckygroup.webapi.models.Category;
import com.luckygroup.webapi.repository.CategoryRepository;
import com.luckygroup.webapi.services.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Category findCategoryById(Long id) {
    Optional<Category> optionalCategory = categoryRepository.findById(id);
    return optionalCategory.orElse(null);
  }

  @Override
  public List<Category> getCategoriesByName(String name) {
    List<Category> CategoryName = categoryRepository.findByName(name);
    return CategoryName;
  }

  @Override
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  public Category saveCategory(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }
  // Bổ sung các phương thức tùy chỉnh nếu cần
}
