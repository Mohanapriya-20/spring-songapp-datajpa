package com.songapp.exceptions;

/**
 * @author MohanapriyaV
 *
 */
public class SingerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SingerNotFoundException() {
		super();
	}

	public SingerNotFoundException(String message) {
		super(message);
	}

}
