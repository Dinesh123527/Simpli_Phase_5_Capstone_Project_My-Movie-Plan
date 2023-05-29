package com.example.capstone.movie.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.capstone.movie.model.MovieResource;

@Component
public interface MovieResourceService {
	List<MovieResource> getAllResources();
}
