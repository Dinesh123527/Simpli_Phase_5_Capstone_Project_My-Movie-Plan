package com.example.capstone.movie.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.capstone.movie.model.MovieResource;

public interface MovieResourceRepo extends CrudRepository<MovieResource, String>{
	List<MovieResource> findAll();
}
