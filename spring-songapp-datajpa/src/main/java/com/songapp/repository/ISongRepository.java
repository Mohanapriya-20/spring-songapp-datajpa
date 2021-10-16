package com.songapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.songapp.model.Song;
/**
 * @author MohanapriyaV
 *
 */
@Repository
public interface ISongRepository extends JpaRepository<Song, Integer> {

	Song findByName(String name);

	// One to One
	@Query("from Song s inner join s.description d where d.lyrics=?1")
	List<Song> findByDescriptionLyrics(String lyrics);

	@Query("from Song s inner join s.description d where d.lyricist=?1")
	List<Song> findByDescriptionLyricist(String lyricist);

	@Query("from Song s inner join s.description d where d.language=?1")
	List<Song> findByDescriptionLanguage(String language);

	@Query("from Song s inner join s.description d where d.views>=?1")
	List<Song> findByDescriptionViews(int views);
	
    @Query("from Song s inner join s.description d where d.language=?1 and s.name=?2")
	List<Song> findByDescriptionLanguageAndSongName(String language, String name);

	// Many to one for Movie
    @Query("from Song s inner join s.movie m where m.movieName=?1")
	List<Song> findByMovieName(String movieName);
    
    @Query("from Song s inner join s.movie m where s.name=?1 and m.movieName=?2")
	Song findBySongNameAndMovieName(String name, String movieName);

	// Many to one for Category
    @Query("from Song s inner join s.category c  where c.categoryName=?1")
	List<Song> findByCategoryName(String categoryName);

	// Many to Many
	@Query("from Song s inner join s.singerList sl  where sl.name=?1 ")
	List<Song> findBySingerName(String name);

}
