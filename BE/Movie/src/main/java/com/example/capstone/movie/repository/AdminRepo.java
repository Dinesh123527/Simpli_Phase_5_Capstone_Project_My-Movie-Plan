package com.example.capstone.movie.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.capstone.movie.model.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer>{
	Admin findByEmailId(String name);
	Admin findByEmailIdAndPassword(String email, String password);
}
