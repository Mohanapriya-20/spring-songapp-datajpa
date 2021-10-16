package com.songapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.songapp.model.Singer;

/**
 * @author MohanapriyaV
 *
 */
@Repository
public interface ISingerRepository extends JpaRepository<Singer, Integer> {
	@Query("from Singer s inner join s.songList sl where sl.name=?1")
	List<Singer> findBySongName(String name);
}
