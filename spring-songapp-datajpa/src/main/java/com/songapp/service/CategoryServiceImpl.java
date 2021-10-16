package com.songapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songapp.exceptions.CategoryNotFoundException;
import com.songapp.exceptions.IdNotFoundException;
import com.songapp.model.Category;
import com.songapp.repository.ICategoryRepository;

/**
 * @author MohanapriyaV
 *
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
	ICategoryRepository categoryRepository;

	@Autowired
	public void setCategoryRepository(ICategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category addCategory(Category category) {

		return categoryRepository.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);

	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
		;

	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getById(int categoryId) throws IdNotFoundException {
		Category category = categoryRepository.findById(categoryId).get();
		if (category == null)
			throw new CategoryNotFoundException("Please Enter Valid Category Id!!");
		return category;
	}

	@Override
	public Category getByCategoryName(String categoryName) throws CategoryNotFoundException {
		Category category = categoryRepository.findByCategoryName(categoryName);
		if (category == null)
			throw new CategoryNotFoundException("Please Enter Valid Category!!");
		return category;
	}

}
