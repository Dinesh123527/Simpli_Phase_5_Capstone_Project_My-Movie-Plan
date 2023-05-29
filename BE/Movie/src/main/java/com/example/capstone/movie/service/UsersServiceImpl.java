package com.example.capstone.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.movie.model.Users;
import com.example.capstone.movie.repository.UsersRepo;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UsersRepo userRepo;

	public Users addUser(Users users) {
		return userRepo.save(users);
	}
	
	public Users getByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public Users getByEmailAndPassword(String email, String pass) {
		return userRepo.findByEmailAndPassword(email, pass);
	}
}
