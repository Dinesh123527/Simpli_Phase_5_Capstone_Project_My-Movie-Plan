package com.example.capstone.movie.service;

import java.util.List;

import org.springframework.stereotype.Component;
import com.example.capstone.movie.exceptions.DeleteMovieException;
import com.example.capstone.movie.exceptions.MovieNotFoundException;
import com.example.capstone.movie.model.MovieCatalogue;


@Component
public interface MovieCatalogueService {
	MovieCatalogue  addMovie(MovieCatalogue mov);
	MovieCatalogue  getMovieById(int mid) throws MovieNotFoundException;
	MovieCatalogue  updateMovie(int mid, MovieCatalogue mov);
	List<MovieCatalogue> deleteMovieById(int mid) throws DeleteMovieException;
	List<MovieCatalogue> getAllMovies();
	List<MovieCatalogue> getByMovieGenre(String mgenre);
	MovieCatalogue getByMovieCode(String name);
}
