package com.example.capstone.movie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= UserExistException.class)
	public ResponseEntity<Object> exception( UserExistException exception) {
		return new ResponseEntity<>("You are already registered", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= UserNotFoundException.class)
	public ResponseEntity<Object> exception( UserNotFoundException exception) {
		return new ResponseEntity<>("User Not Exist", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= AdminUserExistException.class)
	public ResponseEntity<Object> exception( AdminUserExistException exception) {
		return new ResponseEntity<>("You are already registered", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= AdminUserNotFoundException.class)
	public ResponseEntity<Object> exception( AdminUserNotFoundException exception) {
		return new ResponseEntity<>("Admin user does not exist", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= InvalidLoginException.class)
	public ResponseEntity<Object> exception( InvalidLoginException exception) {
		return new ResponseEntity<>("Bad Credentials try again", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value= MovieExistException.class)
	public ResponseEntity<Object> exception(MovieExistException exception) {
		return new ResponseEntity<>("Movie already exist", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= MovieNotFoundException.class)
	public ResponseEntity<Object> exception( MovieNotFoundException exception) {
		return new ResponseEntity<>("Movie not available", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= UpdateMovieException.class)
	public ResponseEntity<Object> exception( UpdateMovieException exception) {
		return new ResponseEntity<>("Cannot update movie not available", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= DeleteMovieException.class)
	public ResponseEntity<Object> exception(DeleteMovieException exception) {
		return new ResponseEntity<>("Cannot delete movie not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= GenreException.class)
	public ResponseEntity<Object> exception(GenreException exception) {
		return new ResponseEntity<>("No such Movie Genre Exist", HttpStatus.NOT_FOUND);
	}
}
