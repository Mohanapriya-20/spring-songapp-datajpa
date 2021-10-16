package com.songapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.songapp.model.Category;

/**
 * @author MohanapriyaV
 *
 */
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
	Category findByCategoryName(String name);

}
