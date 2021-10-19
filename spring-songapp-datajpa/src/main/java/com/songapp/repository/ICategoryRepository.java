package com.songapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.songapp.model.Category;

/**
 * @author MohanapriyaV
 *
 */
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
	@Query("from Category c inner join c.songList s  where s.name=?1")
	Category findBySongName(String name);

}
