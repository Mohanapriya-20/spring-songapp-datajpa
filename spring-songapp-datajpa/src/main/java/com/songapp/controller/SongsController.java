package com.songapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.songapp.model.Song;
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

	@PostMapping("/songs")
	public ResponseEntity<Song> addSong(@RequestBody Song song) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Song Added");
		Song songNew = songService.addSong(song);
		return ResponseEntity.ok().headers(headers).body(songNew);
	}

	@PutMapping("/songs")
	public ResponseEntity<Void> updateSong(@RequestBody Song song) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Song Updated");
		songService.updateSong(song);
		return ResponseEntity.ok().headers(headers).build();
	}

	@DeleteMapping("/songs/{songId}")
	ResponseEntity<Void> deleteSong(@PathVariable("songId") int songId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Song Deleted");
		songService.deleteSong(songId);
		return ResponseEntity.ok().headers(headers).build();
	}

	@GetMapping("/songs")
	public ResponseEntity<List<Song>> getAllSongs() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Songs");
		List<Song> songList = songService.getAll();
		return ResponseEntity.ok().headers(headers).body(songList);
	}

	@GetMapping("/songs/{songId}")
	public ResponseEntity<Song> getById(@PathVariable("songId") int songId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Id");
		Song songNew = songService.getById(songId);
		return ResponseEntity.ok().headers(headers).body(songNew);
	}

	@GetMapping("/songs/name/{name}")
	public ResponseEntity<Song> getByName(@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Name");
		Song songNew = songService.getByName(name);
		return ResponseEntity.ok().headers(headers).body(songNew);

	}

	@GetMapping("/songs/lyrics/{lyrics}")
	public ResponseEntity<List<Song>> getByDescriptionLyrics(@PathVariable("lyrics") String lyrics) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Lyrics");
		List<Song> songList = songService.getByDescriptionLyrics(lyrics);
		return ResponseEntity.ok().headers(headers).body(songList);
	}

	@GetMapping("/songs/lyricist/{lyricist}")
	public ResponseEntity<List<Song>> getByDescriptionLyricist(@PathVariable("lyricist") String lyricist) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Lyricist");
		List<Song> songList = songService.getByDescriptionLyricist(lyricist);
		return ResponseEntity.ok().headers(headers).body(songList);
	}

	@GetMapping("/songs/language/{language}")
	public ResponseEntity<List<Song>> getByDescriptionLanguage(@PathVariable("language") String language) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Language");
		List<Song> songList = songService.getByDescriptionLanguage(language);
		return ResponseEntity.ok().headers(headers).body(songList);
	}

	@GetMapping("/songs/views/{views}")
	public ResponseEntity<List<Song>> getByDescriptionViews(@PathVariable("views") int views) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Views");
		List<Song> songList = songService.getByDescriptionViews(views);
		return ResponseEntity.ok().headers(headers).body(songList);

	}

	@GetMapping("/songs/language/{language}/name/{name}")
	public ResponseEntity<List<Song>> getByDescriptionLanguageAndName(@PathVariable("language") String language,
			@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Language and Name");
		List<Song> songList = songService.getByDescriptionLanguageAndSongName(language, name);
		return ResponseEntity.ok().headers(headers).body(songList);
	}

	@GetMapping("/songs/moviename/{movieName}")
	public ResponseEntity<List<Song>> getByMovieName(@PathVariable("movieName") String movieName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Language and Name");
		List<Song> songList = songService.getByMovieName(movieName);
		return ResponseEntity.ok().headers(headers).body(songList);
	}

	@GetMapping("/songs/name/{name}/moviename/{movieName}")
	public ResponseEntity<Song> findBySongNameAndMovieName(@PathVariable("name") String name,
			@PathVariable("movieName") String movieName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Language and Name");
		Song songNew = songService.getBySongNameAndMovieMovieName(name, movieName);
		return ResponseEntity.ok().headers(headers).body(songNew);
	}

	// Many to Many
	@GetMapping("/songs/singername/{name}")
	public ResponseEntity<List<Song>> getBySingerName(@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Singer Name");
		List<Song> songList = songService.getBySingerName(name);
		return ResponseEntity.ok().headers(headers).body(songList);
	}

	// Many to One for Category
	@GetMapping("/songs/categoryname/{categoryName}")
	public ResponseEntity<List<Song>> getByCategoryName(@PathVariable("categoryName") String categoryName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Song By Category");
		List<Song> songList = songService.getByCategoryName(categoryName);
		return ResponseEntity.ok().headers(headers).body(songList);
	}

}
