package com.songapp.exceptions;

/**
 * @author MohanapriyaV
 *
 */
public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieNotFoundException() {
		super();
	}

	public MovieNotFoundException(String message) {
		super(message);
	}

}
