package com.songapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.songapp.model.Description;

/**
 * @author MohanapriyaV
 *
 */
@Repository
public interface IDescriptionRepository extends JpaRepository<Description, Integer> {
	@Query("from Description d inner join d.song s  where s.name=?1")
	Description findBySongName(String name);

}
