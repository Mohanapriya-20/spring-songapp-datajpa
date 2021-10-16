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
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}

	@PutMapping("/movies")
	public void updateMovie(@RequestBody Movie movie) {
		movieService.updateMovie(movie);
	}

	@DeleteMapping("/movies/{movieId}")
	void deleteSinger(@PathVariable("movieId") int movieId) {
		movieService.deleteMovie(movieId);
	}

	@GetMapping("/movies")

	public List<Movie> getAllMovies() {
		return movieService.getAll();
	}

	@GetMapping("/movies/{movieId}")
	public Movie getById(@PathVariable("movieId") int songId) {
		return movieService.getById(songId);
	}

	@GetMapping("/movies/songname/{name}")
	Movie getBySongName(@PathVariable("name") String name) {
		return movieService.getBySongName(name);
	}

}
