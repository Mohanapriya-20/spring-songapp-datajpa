package com.songapp.service;

import java.util.List;

import com.songapp.exceptions.IdNotFoundException;
import com.songapp.exceptions.MovieNotFoundException;
import com.songapp.model.Movie;

/**
 * @author MohanapriyaV
 *
 */
public interface IMovieService {
	Movie addMovie(Movie movie);

	void updateMovie(Movie movie);

	void deleteMovie(int movieId);

	List<Movie> getAll();

	Movie getById(int movieId) throws IdNotFoundException;

	Movie getBySongName(String name) throws MovieNotFoundException;

}
