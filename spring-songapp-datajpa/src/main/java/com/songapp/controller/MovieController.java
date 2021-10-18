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

import com.songapp.model.Movie;
import com.songapp.service.IMovieService;

/**
 * @author MohanapriyaV
 *
 */
@RestController
@RequestMapping("/movie-api")
public class MovieController {
	@Autowired
	IMovieService movieService;

	@PostMapping("/movies")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Movie Added");
		Movie movieNew = movieService.addMovie(movie);
		return ResponseEntity.ok().headers(headers).body(movieNew);
	}

	@PutMapping("/movies")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Movie Updated");
		movieService.updateMovie(movie);
		return ResponseEntity.ok().headers(headers).build();
	}

	@DeleteMapping("/movies/{movieId}")
	ResponseEntity<Void> deleteSinger(@PathVariable("movieId") int movieId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Movie Deleted");
		movieService.deleteMovie(movieId);
		return ResponseEntity.ok().headers(headers).build();
	}

	@GetMapping("/movies")

	public ResponseEntity<List<Movie>> getAllMovies() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving All Movies");
		List<Movie> movieList = movieService.getAll();
		return ResponseEntity.ok().headers(headers).body(movieList);
	}

	@GetMapping("/movies/{movieId}")
	public ResponseEntity<Movie> getById(@PathVariable("movieId") int songId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Movies By Id");
		Movie movieNew = movieService.getById(songId);
		return ResponseEntity.ok().headers(headers).body(movieNew);

	}

	@GetMapping("/movies/songname/{name}")
	ResponseEntity<Movie> getBySongName(@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Retriving Movies By Song Name");
		Movie movieNew = movieService.getBySongName(name);
		return ResponseEntity.ok().headers(headers).body(movieNew);
	}

}
