package com.example.capstone.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.movie.model.Admin;
import com.example.capstone.movie.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepo adminRepo;
	
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	public Admin getByEmailId(String email) {
		return adminRepo.findByEmailId(email);
	}

	@Override
	public Admin getByEmailIdAndPassword(String eid, String pass) {
		return adminRepo.findByEmailIdAndPassword(eid, pass);
	}

}
