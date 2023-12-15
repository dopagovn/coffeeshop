package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Category;
import com.luckygroup.webapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/category/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Long id) {
        try {
            Category category = categoryService.findCategoryById(id);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Successful",
                    category
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed",
                    null
            );
        }
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<Object> getAllCategories() {
        try {
            List<Category> categories = categoryService.getAllCategories();
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Successful",
                    categories
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed",
                    null
            );
        }
    }

    @PostMapping("/category")
    public ResponseEntity<Object> saveCategory(@RequestBody Category category) {
        try {
            Category savedCategory = categoryService.saveCategory(category);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Category saved successfully",
                    savedCategory
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Cannot save category",
                    null
            );
        }
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Category deleted successfully",
                    null
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Cannot delete category",
                    null
            );
        }
    }

    // Bổ sung các phương thức khác tại đây

    // Ví dụ:
    @GetMapping(path = "/categories-by-name/{name}")
    public ResponseEntity<Object> getCategoriesByName(@PathVariable String name) {
        try {
            List<Category> categories = categoryService.getCategoriesByName(name);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Successful",
                    categories
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed",
                    null
            );
        }
    }
}
