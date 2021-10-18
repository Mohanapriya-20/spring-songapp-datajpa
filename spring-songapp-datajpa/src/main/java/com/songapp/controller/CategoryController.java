package com.songapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Category Added");
		Category categoryNew = categoryService.addCategory(category);
		return ResponseEntity.ok().headers(headers).body(categoryNew);
	}

	@PutMapping("/categories")
	public ResponseEntity<Void> updateMovie(@RequestBody Category category) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Category Updated");
		categoryService.updateCategory(category);
		return ResponseEntity.ok().headers(headers).build();
	}

	@DeleteMapping("/categories/{categoryId}")
	ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") int categoryId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Category Updated");
		categoryService.deleteCategory(categoryId);
		return ResponseEntity.ok().headers(headers).build();
	}

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving All Categories");
		List<Category> categoryList = categoryService.getAll();
		return ResponseEntity.ok().headers(headers).body(categoryList);
	}

	@GetMapping("/categories/{categoryId}")
	public ResponseEntity<Category> getById(@PathVariable("categoryId") int categoryId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Categories By Id");
		Category categoryNew = categoryService.getById(categoryId);
		return ResponseEntity.ok().headers(headers).body(categoryNew);
	}

	@GetMapping("/categories/categoryName/{CategoryName}")
	ResponseEntity<Category> getByCategoryName(@PathVariable("CategoryName") String CategoryName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Categories By CategoryName");
		Category categoryNew = categoryService.getByCategoryName(CategoryName);
		return ResponseEntity.ok().headers(headers).body(categoryNew);
	}

}
