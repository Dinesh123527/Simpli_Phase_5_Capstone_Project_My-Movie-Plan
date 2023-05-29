package com.example.capstone.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.capstone.movie.model.MovieResource;
import com.example.capstone.movie.repository.MovieResourceRepo;


@Service
public class MovieResourceServiceImpl implements MovieResourceService{
	
	@Autowired
	private MovieResourceRepo movResourceRepo;
	
	public List<MovieResource> getAllResources() {
		List<MovieResource> movResourceList = new ArrayList<MovieResource>();
		movResourceList = movResourceRepo.findAll().stream().collect(Collectors.toList());
		return movResourceList;
	}
}
