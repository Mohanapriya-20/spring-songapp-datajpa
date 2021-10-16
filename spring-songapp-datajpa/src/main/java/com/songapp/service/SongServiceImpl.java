package com.songapp.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.songapp.exceptions.IdNotFoundException;
import com.songapp.exceptions.SongNotFoundException;
import com.songapp.model.Song;
import com.songapp.repository.ISongRepository;

/**
 * @author MohanapriyaV
 *
 */
@Service
@Transactional
public class SongServiceImpl implements ISongService {
	@Autowired
	ISongRepository songRepository;

	public void setSongRepository(ISongRepository songRepository) {
		this.songRepository = songRepository;
	}

	@Override
	public Song addSong(Song song) {

		return songRepository.save(song);
	}

	@Override
	public void updateSong(Song song) {
		songRepository.save(song);
	}

	@Override
	public void deleteSong(int songId) {
		songRepository.deleteById(songId);

	}

	@Override
	public List<Song> getAll() {

		return songRepository.findAll();
	}

	@Override
	public Song getById(int songId) throws IdNotFoundException {

		Song song = songRepository.findById(songId).get();
		if (song == null)
			throw new SongNotFoundException("Song Id Not Found");
		return song;
	}

	@Override
	public Song getByName(String name) throws SongNotFoundException {
		Song song = songRepository.findByName(name);
		if (song == null)
			throw new SongNotFoundException("Invalid Song Name");
		return song;
	}

	@Override
	public List<Song> getByDescriptionLyrics(String lyrics) throws SongNotFoundException {
		List<Song> songList = songRepository.findByDescriptionLyrics(lyrics);
		if (songList.isEmpty())
			throw new SongNotFoundException("Invalid Lyrics");
		return songList;
	}

	@Override
	public List<Song> getByDescriptionLyricist(String lyricist) throws SongNotFoundException {
		List<Song> songList = songRepository.findByDescriptionLyricist(lyricist);
		if (songList.isEmpty())
			throw new SongNotFoundException("Invalid Lyricist Name");
		return songList;
	}

	@Override
	public List<Song> getByDescriptionLanguage(String language) throws SongNotFoundException {
		List<Song> songList = songRepository.findByDescriptionLanguage(language);
		if (songList.isEmpty())
			throw new SongNotFoundException(" Invalid Language");
		return songList;
	}

	@Override
	public List<Song> getByDescriptionViews(int views) throws SongNotFoundException {
		List<Song> songList = songRepository.findByDescriptionViews(views);
		if (songList.isEmpty())
			throw new SongNotFoundException("Please Enter Valid Range For Views!!");
		return songList;
	}

	@Override
	public List<Song> getByDescriptionLanguageAndSongName(String language, String name) throws SongNotFoundException {
		List<Song> songList = songRepository.findByDescriptionLanguageAndSongName(language, name);
		if (songList.isEmpty())
			throw new SongNotFoundException("Please Enter Valid Language And Song Name!!");
		return songList;
	}

	@Override
	public List<Song> getByMovieName(String movieName) throws SongNotFoundException {

		List<Song> songList = songRepository.findByMovieName(movieName);
		if (songList.isEmpty())
			throw new SongNotFoundException("Please Enter Valid Movie Name!!");
		return songList;
	}

	@Override
	public Song getBySongNameAndMovieMovieName(String name, String movieName) throws SongNotFoundException {

		Song song = songRepository.findBySongNameAndMovieName(name, movieName);
		if (song == null)
			throw new SongNotFoundException("Please Enter Valid Song Name And Movie Name!!");
		return song;
	}

	@Override
	public List<Song> getBySingerName(String name) throws SongNotFoundException {
		List<Song> songList = songRepository.findBySingerName(name);
		if (songList.isEmpty())
			throw new SongNotFoundException("Please Enter Valid Singer Name!!");
		return songList;
	}

	@Override
	public List<Song> getByCategoryName(String categoryName) throws SongNotFoundException {
		List<Song> songList = songRepository.findByCategoryName(categoryName);
		if (songList.isEmpty())
			throw new SongNotFoundException("Please Enter Valid Category!!");
		return songList;
	}

}