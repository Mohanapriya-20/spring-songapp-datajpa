package com.songapp.service;

import java.util.List;
import com.songapp.exceptions.IdNotFoundException;
import com.songapp.exceptions.SongNotFoundException;
import com.songapp.model.Song;

/**
 * @author MohanapriyaV
 *
 */
public interface ISongService {
	Song addSong(Song song);

	void updateSong(Song song);

	void deleteSong(int songId);

	List<Song> getAll();

	Song getById(int songId) throws IdNotFoundException;

	Song getByName(String name) throws SongNotFoundException;

//one to One
	List<Song> getByDescriptionLyrics(String lyrics) throws SongNotFoundException;

	List<Song> getByDescriptionLyricist(String lyricist) throws SongNotFoundException;

	List<Song> getByDescriptionLanguage(String language) throws SongNotFoundException;

	List<Song> getByDescriptionViews(int views) throws SongNotFoundException;

	List<Song> getByDescriptionLanguageAndSongName(String language, String name) throws SongNotFoundException;

//One to Many
	List<Song> getByMovieName(String movieName) throws SongNotFoundException;

	Song getBySongNameAndMovieMovieName(String name, String movieName) throws SongNotFoundException;

//Many to Many
	List<Song> getBySingerName(String name) throws SongNotFoundException;

//One to Many
	List<Song> getByCategoryName(String categoryName) throws SongNotFoundException;
}
