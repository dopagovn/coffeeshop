package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.models.Category;
import com.luckygroup.webapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/categories")
    public ResponseEntity<?> getAllCategories() {
        Optional<List<Category>> categories = categoryService.getAllCategories();
        if (categories.isPresent()) {
            return ResponseEntity.ok(categories.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Categories not found");
        }
    }

    @GetMapping(path = "/category")
    public ResponseEntity<?> getCategoryById(@RequestParam int id) {
        Optional<Category> category = categoryService.getCategoryById(id);

        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Category not found");
        }
    }

    @PostMapping(path = "/category")
    public ResponseEntity<String> saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return ResponseEntity.ok("Category saved successfully");
    }

    @DeleteMapping(path = "/category")
    public ResponseEntity<String> deleteCategory(@RequestParam int id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }

    // Additional methods can be added here

    // Example:
    @GetMapping(path = "/categories-by-name")
    public ResponseEntity<?> getCategoriesByName(@RequestParam String name) {
        Optional<Category> categories = categoryService.getCategoriesByName(name);
        if (!categories.isEmpty()) {
            return ResponseEntity.ok(categories);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Categories not found for the given name");
        }
    }
}
