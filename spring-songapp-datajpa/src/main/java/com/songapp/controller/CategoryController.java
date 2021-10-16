package com.songapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.songapp.model.Category;
import com.songapp.service.ICategoryService;

/**
 * @author MohanapriyaV
 *
 */
@RestController
@RequestMapping("/category-api")
public class CategoryController {
	@Autowired
	ICategoryService categoryService;

	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@PutMapping("/categories")
	public void updateMovie(@RequestBody Category category) {
		categoryService.updateCategory(category);
	}

	@DeleteMapping("/categories/{categoryId}")
	void deleteCategory(@PathVariable("categoryId") int categoryId) {
		categoryService.deleteCategory(categoryId);
	}

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryService.getAll();
	}

	@GetMapping("/categories/{categoryId}")
	public Category getById(@PathVariable("categoryId") int categoryId) {
		return categoryService.getById(categoryId);
	}

	@GetMapping("/categories/categoryName/{CategoryName}")
	Category getByCategoryName(@PathVariable("CategoryName") String CategoryName) {
		return categoryService.getByCategoryName(CategoryName);
	}

}
