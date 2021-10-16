package com.songapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songapp.exceptions.IdNotFoundException;
import com.songapp.exceptions.MovieNotFoundException;
import com.songapp.model.Movie;
import com.songapp.repository.IMovieRepository;

/**
 * @author MohanapriyaV
 *
 */
@Service
public class MovieServiceImpl implements IMovieService {
	IMovieRepository movieRepository;

	@Autowired
	public void setMovieRepository(IMovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public void updateMovie(Movie movie) {
		movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(int movieId) {
		movieRepository.deleteById(movieId);

	}

	@Override
	public List<Movie> getAll() {

		return movieRepository.findAll();
	}

	@Override
	public Movie getById(int movieId) throws IdNotFoundException {
		Movie movie = movieRepository.findById(movieId).get();
		if (movie == null)
			throw new IdNotFoundException("Please Enter Valid Song Id!!");
		return movie;
	}

	@Override
	public Movie getBySongName(String name) throws MovieNotFoundException {
		Movie movie = movieRepository.findBySongName(name);
		if (movie == null)
			throw new MovieNotFoundException("Please Enter Valid Song Name!!");
		return movie;
	}

}
