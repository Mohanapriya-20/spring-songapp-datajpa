package com.songapp.service;

import java.util.List;
import com.songapp.exceptions.CategoryNotFoundException;
import com.songapp.exceptions.IdNotFoundException;
import com.songapp.model.Category;

/**
 * @author MohanapriyaV
 *
 */
public interface ICategoryService {
	Category addCategory(Category category);

	void updateCategory(Category category);

	void deleteCategory(int categoryId);

	List<Category> getAll();

	Category getById(int categoryId) throws IdNotFoundException;

	Category getByCategoryName(String categoryName) throws CategoryNotFoundException;
}
