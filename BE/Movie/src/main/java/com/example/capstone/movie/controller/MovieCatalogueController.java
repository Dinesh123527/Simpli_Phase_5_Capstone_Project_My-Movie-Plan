package com.example.capstone.movie.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.capstone.movie.exceptions.DeleteMovieException;
import com.example.capstone.movie.exceptions.GenreException;
import com.example.capstone.movie.exceptions.MovieExistException;
import com.example.capstone.movie.exceptions.MovieNotFoundException;
import com.example.capstone.movie.exceptions.UpdateMovieException;
import com.example.capstone.movie.model.MovieCatalogue;
import com.example.capstone.movie.service.MovieCatalogueService;


@RestController
public class MovieCatalogueController {
	
	@Autowired
	private MovieCatalogueService movService;
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value="/addmovie")
	 public ResponseEntity<MovieCatalogue> addMovie(@RequestBody MovieCatalogue mov) throws Exception{
    	String tempMovieCode = mov.getMovieCode();
		if(tempMovieCode != null && !"".equals(tempMovieCode)) {
			MovieCatalogue movObj = movService.getByMovieCode(tempMovieCode);
		    if(movObj != null ) {
		    	throw new MovieExistException();
		    }
		}
    	MovieCatalogue movobj = null;
		 movobj = movService.addMovie(mov);
		return new ResponseEntity<MovieCatalogue>(movobj, HttpStatus.CREATED);
	}
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
    @GetMapping(value="/movies/{mid}")
	 public ResponseEntity<MovieCatalogue> getMovieById(@PathVariable("mid") int mid) throws MovieNotFoundException {
			  MovieCatalogue mov = movService.getMovieById(mid);
			  return new ResponseEntity<MovieCatalogue>(mov, HttpStatus.OK);	
	 }
	 
	 @CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	 @PutMapping(value="updatemovie/{mid}")
      public ResponseEntity<MovieCatalogue> updateMovie(@PathVariable int mid, @RequestBody MovieCatalogue mov) throws Exception {
   	  MovieCatalogue movie = movService.updateMovie(mid, mov);
   	     if (movie != null ) {
   		    return new ResponseEntity<MovieCatalogue>(movie, HttpStatus.OK);
   	     } else {
   		    throw new UpdateMovieException();
   	     }
     }
	 
	 @CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	 @DeleteMapping(value="/deletemovie/{mid}")
	 public ResponseEntity<List<MovieCatalogue>> deleteMovieById(@PathVariable("mid") int mid) throws DeleteMovieException {
	     List<MovieCatalogue> movList = movService.deleteMovieById(mid);
	     return new ResponseEntity<>(movList, HttpStatus.ACCEPTED);
	 }
	 
	 @CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	 @GetMapping(value="/getallmovies")
	  public ResponseEntity<List<MovieCatalogue>> getAllMovies() {
			List<MovieCatalogue> movList = movService.getAllMovies();
			return new ResponseEntity<>(movList, HttpStatus.OK);
	  } 
	 
	 @CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	 @GetMapping(value="/movies/genre/{genre}")
	  public ResponseEntity<List<MovieCatalogue>> getByMovieGenre( @PathVariable("genre") String mgenre) throws Exception{
			List<MovieCatalogue> movList = movService.getByMovieGenre(mgenre);
			  if (!movList.isEmpty()) {
				  return new ResponseEntity<>(movList, HttpStatus.OK);
			 } else {
				  throw new GenreException();
			 }
	  }
}
