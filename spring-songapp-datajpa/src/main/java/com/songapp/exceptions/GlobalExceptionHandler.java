package com.songapp.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.songapp.model.ApiErrors;

/**
 * @author MohanapriyaV
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Method not allowed";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Invalid Media type";
		int nstatus = status.value();
		ApiErrors errors = new ApiErrors(timestamp, message, nstatus, error);
		return ResponseEntity.status(status.value()).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Path variable is missing";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Request parameter is missing";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Type Mismatch";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@ExceptionHandler(SongNotFoundException.class)
	protected ResponseEntity<Object> handleSongNotFound(SongNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Song Not Available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	@ExceptionHandler(CategoryNotFoundException.class)
	protected ResponseEntity<Object> handleCategoryNotFound(CategoryNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Category Not Available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	@ExceptionHandler(MovieNotFoundException.class)
	protected ResponseEntity<Object> handleMovieNotFound(MovieNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Movie Not Available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	@ExceptionHandler(SingerNotFoundException.class)
	protected ResponseEntity<Object> handleSingerNotFound(SingerNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Singer Not Available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	@ExceptionHandler(IdNotFoundException.class)
	protected ResponseEntity<Object> handleIdNotFound(IdNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Id Not Available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleOther(Exception ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Other Exception";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.BAD_GATEWAY.value(), error);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errors);
	}

}
