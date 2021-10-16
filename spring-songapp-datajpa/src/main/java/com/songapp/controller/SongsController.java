package com.songapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.songapp.model.Description;
import com.songapp.model.Song;
import com.songapp.service.IDescriptionService;
import com.songapp.service.ISongService;

/**
 * @author MohanapriyaV
 *
 */
@RestController
@RequestMapping("/song-api")
public class SongsController {
	@Autowired
	ISongService songService;
	@Autowired
	IDescriptionService descriptionService;

	@PostMapping("/songs")
	public Song addSong(@RequestBody Song song) {
		return songService.addSong(song);
	}

	@PutMapping("/songs")
	public void updateSong(@RequestBody Song song) {
		songService.updateSong(song);
	}

	@DeleteMapping("/songs/{songId}")
	void deleteSong(@PathVariable("songId") int songId) {
		songService.deleteSong(songId);
	}

	@GetMapping("/songs")
	public List<Song> getAllSongs() {
		return songService.getAll();
	}

	@GetMapping("/songs/{songId}")
	public Song getById(@PathVariable("songId") int songId) {
		return songService.getById(songId);
	}

	@GetMapping("/songs/name/{name}")
	public Song getByName(@PathVariable("name") String name) {
		return songService.getByName(name);
	}
	@GetMapping("/songs/lyrics/{lyrics}")
	public List<Song> getByDescriptionLyrics(@PathVariable("lyrics") String lyrics) {
		return songService.getByDescriptionLyrics(lyrics);
	}

	@GetMapping("/songs/lyricist/{lyricist}")
	public List<Song> getByDescriptionLyricist(@PathVariable("lyricist") String lyricist) {
		return songService.getByDescriptionLyricist(lyricist);
	}

	@GetMapping("/songs/language/{language}")
	public List<Song> getByDescriptionLanguage(@PathVariable("language") String language) {
		return songService.getByDescriptionLanguage(language);
	}

	@GetMapping("/songs/views/{views}")
	public List<Song> getByDescriptionViews(@PathVariable("views") int views) {
		return songService.getByDescriptionViews(views);
	}

	@GetMapping("/songs/language/{language}/name/{name}")
	public List<Song> getByDescriptionLanguageAndName(@PathVariable("language") String language,
			@PathVariable("name") String name) {
		return songService.getByDescriptionLanguageAndSongName(language, name);
	}

	@GetMapping("/songs/moviename/{movieName}")
	public List<Song> getByMovieName(@PathVariable("movieName") String movieName) {
		return songService.getByMovieName(movieName);
	}

	@GetMapping("/songs/name/{name}/moviename/{movieName}")
	public Song findBySongNameAndMovieName(@PathVariable("name") String name,
			@PathVariable("movieName") String movieName) {
		return songService.getBySongNameAndMovieMovieName(name, movieName);
	}

	// Many to Many
	@GetMapping("/songs/singername/{name}")
	public List<Song> getBySingerName(@PathVariable("name") String name) {
		return songService.getBySingerName(name);
	}

	// Many to One for Category
	@GetMapping("/songs/categoryname/{categoryName}")
	public List<Song> getByCategoryName(@PathVariable("categoryName") String categoryName) {
		return songService.getByCategoryName(categoryName);
	}
	@PostMapping("/description")
	public void addDescription(@RequestBody Description description) {
		   descriptionService.addDescription(description);
	}
	@PutMapping("/description")
	public void updateDescription(@RequestBody Description description) {
		   descriptionService.updateDescription(description);
	}
	@DeleteMapping("/description/{descriptionId}")
	public void deleteDescription(@PathVariable("descriptionId") int descriptionId) {
		   descriptionService.deleteDescription(descriptionId);
	}

	@GetMapping("/description/songname/{name}")
	public Description findBySongName(@PathVariable("name") String name) {
		return descriptionService.getBySongName(name);
	}
}
