package com.example.capstone.movie.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.capstone.movie.model.MovieCatalogue;

public interface MovieCatalogueRepo extends CrudRepository<MovieCatalogue, Integer> {
	List<MovieCatalogue> findAll();
	MovieCatalogue getByMovieCode(String name);
}
