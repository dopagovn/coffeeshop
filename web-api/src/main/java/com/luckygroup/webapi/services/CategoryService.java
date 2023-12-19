package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Category;
import java.util.List;

public interface CategoryService {
  Category findCategoryById(Long id);
  List<Category> getAllCategories();
  Category saveCategory(Category category);
  void deleteCategory(Long id);
  List<Category> getCategoriesByName(String name);
  // Bổ sung các phương thức tùy chỉnh nếu cần
}
