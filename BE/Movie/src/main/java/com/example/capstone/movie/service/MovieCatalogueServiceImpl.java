package com.example.capstone.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.capstone.movie.exceptions.DeleteMovieException;
import com.example.capstone.movie.exceptions.MovieNotFoundException;
import com.example.capstone.movie.model.MovieCatalogue;
import com.example.capstone.movie.repository.MovieCatalogueRepo;

@Service
public class MovieCatalogueServiceImpl implements MovieCatalogueService{
	
	@Autowired
	MovieCatalogueRepo movRepo;

	public MovieCatalogue addMovie(MovieCatalogue mov) {
		return movRepo.save(mov);
	}

	public MovieCatalogue getMovieById(int mid) throws MovieNotFoundException {
		return movRepo.findById(mid).orElseThrow(() -> new MovieNotFoundException());
	}

	public MovieCatalogue updateMovie(int mid, MovieCatalogue mov) {
		if(movRepo.findById(mid).isPresent()) {
			MovieCatalogue oldMov = movRepo.findById(mid).get();
			oldMov.setCast(mov.getCast());
			oldMov.setDirector(mov.getDirector());
			oldMov.setMdesc(mov.getMdesc());
			oldMov.setMgenre(mov.getMgenre());
			oldMov.setRunTime(mov.getRunTime());
			oldMov.setTicketPrice(mov.getTicketPrice());
			return movRepo.save(oldMov);
		} else {
			return null;
		}
	}

	public List<MovieCatalogue> deleteMovieById(int mid) throws DeleteMovieException {
		List<MovieCatalogue> movList = new ArrayList<MovieCatalogue>();
		if(movRepo.findById(mid).isPresent()) {
			movRepo.deleteById(mid);
			movList = movRepo.findAll().stream().collect(Collectors.toList());
			return movList;
		} else {
			throw new DeleteMovieException();
		}
	}

	public List<MovieCatalogue> getAllMovies() {
		List<MovieCatalogue> movList = new ArrayList<MovieCatalogue>();
		movList = movRepo.findAll().stream().collect(Collectors.toList());
		return movList;
	}

	public List<MovieCatalogue> getByMovieGenre(String mgenre) {
		List<MovieCatalogue> movList = new ArrayList<MovieCatalogue>();
		movList = movRepo.findAll().stream().
				filter(res -> res.getMgenre().equals(mgenre)).collect(Collectors.toList());
		return movList;
	}

	@Override
	public MovieCatalogue getByMovieCode(String name) {
		return movRepo.getByMovieCode(name);
	}
}
