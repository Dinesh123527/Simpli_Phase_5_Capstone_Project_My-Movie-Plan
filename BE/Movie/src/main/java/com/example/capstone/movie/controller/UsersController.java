package com.example.capstone.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.capstone.movie.exceptions.InvalidLoginException;
import com.example.capstone.movie.exceptions.UserExistException;
import com.example.capstone.movie.exceptions.UserNotFoundException;
import com.example.capstone.movie.model.Users;
import com.example.capstone.movie.service.UsersService;
import jakarta.validation.Valid;

@RestController
@Validated
public class UsersController {
	
	@Autowired
	private UsersService userService;

   @CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
   @PostMapping(value="/adduser")
	public ResponseEntity<Users> addUser(@Valid @RequestBody Users user) throws Exception{
		String tempEmail = user.getEmail();
		if(tempEmail != null && !"".equals(tempEmail)) {
			Users userObj = userService.getByEmail(tempEmail);
			if(userObj != null) {
				throw new UserExistException();
			}
		}
		Users usrObj = null;
		usrObj= userService.addUser(user);
		return new ResponseEntity<Users>(usrObj, HttpStatus.CREATED);
	}
   
   @CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value="/user/{email}")
	public ResponseEntity<Users> getByEmail(@PathVariable("email") String email) throws Exception{
		Users user = userService.getByEmail(email);
		if(user == null) {
			throw new UserNotFoundException();
		}
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}
   
   @CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value="/userlogin")
	public ResponseEntity<Users> getByEmailAndPassword(@RequestBody Users user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPass = user.getPassword();
		Users userObj = null;
		if (tempEmail != null && tempPass != null) {
			userObj  = userService.getByEmailAndPassword(tempEmail, tempPass);			
		}
		if (userObj == null) {
			throw new InvalidLoginException();
		}
		return new ResponseEntity<Users>(userObj, HttpStatus.OK);
	}
}
