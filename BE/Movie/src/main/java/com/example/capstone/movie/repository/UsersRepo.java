package com.example.capstone.movie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.capstone.movie.model.Users;

@Repository
public interface UsersRepo extends CrudRepository<Users, Integer>{
	Users findByEmail(String name);
	Users findByEmailAndPassword(String email, String password);
}
