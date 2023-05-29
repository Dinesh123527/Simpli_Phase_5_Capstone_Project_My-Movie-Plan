package com.example.capstone.movie.service;

import org.springframework.stereotype.Component;
import com.example.capstone.movie.model.Users;


@Component
public interface UsersService {
	Users addUser(Users users);
	Users getByEmail(String name);
	Users getByEmailAndPassword(String email, String upass);
}
