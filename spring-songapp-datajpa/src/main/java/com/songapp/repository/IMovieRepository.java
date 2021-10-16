package com.songapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.songapp.model.Movie;

/**
 * @author MohanapriyaV
 *
 */
@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
	@Query("from Movie m inner join m.songList sl where sl.name=?1")
	Movie findBySongName(String name);

}
