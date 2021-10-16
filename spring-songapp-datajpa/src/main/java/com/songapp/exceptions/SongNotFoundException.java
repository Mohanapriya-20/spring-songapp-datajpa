package com.songapp.exceptions;

/**
 * @author MohanapriyaV
 *
 */
public class SongNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SongNotFoundException() {
		super();
	}

	public SongNotFoundException(String message) {
		super(message);
	}

}
