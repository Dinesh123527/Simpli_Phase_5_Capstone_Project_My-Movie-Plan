package com.example.capstone.movie.service;

import org.springframework.stereotype.Component;

import com.example.capstone.movie.model.Admin;

@Component
public interface AdminService {
	Admin addAdmin(Admin admin);
	Admin getByEmailId(String name);
	Admin getByEmailIdAndPassword(String email, String pass);
}
