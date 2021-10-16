package com.songapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.songapp.model.Description;

/**
 * @author MohanapriyaV
 *
 */
@Repository
public interface IDescriptionRepository extends JpaRepository<Description, Integer> {
	Description findBySongName(String name);

}
