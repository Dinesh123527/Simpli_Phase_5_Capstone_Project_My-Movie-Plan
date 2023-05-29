package com.example.capstone.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstone.movie.model.MovieResource;
import com.example.capstone.movie.service.MovieResourceService;

@RestController
public class MovieResourceController {
	
	@Autowired
	private MovieResourceService movResourceService;
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value="/movresources")
	public ResponseEntity<List<MovieResource>> getAllResources() {
		   List<MovieResource> movresourceList = movResourceService.getAllResources();
		   return new ResponseEntity<>(movresourceList, HttpStatus.OK);
	}
}
