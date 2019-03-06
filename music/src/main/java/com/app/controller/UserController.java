package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.repository.UserRepo;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserRepo userRepository;
	
	
	@RequestMapping(value="/signup",
					consumes=MediaType.APPLICATION_JSON_VALUE,
					method=RequestMethod.POST)
	
	public void saveUser(@RequestBody User user) {
		System.out.println(user);
		userRepository.save(user);
		
	}
	@RequestMapping(value="/findUserByAlias",
					produces=MediaType.APPLICATION_JSON_VALUE,
					method=RequestMethod.GET)
	@ResponseBody
			private ResponseEntity<User> findUser(String alias){
			
			User user = userRepository.findOne(alias);
			return new ResponseEntity<User>(user, HttpStatus.OK);
			
	}
	@RequestMapping(value="/login",
					produces=MediaType.APPLICATION_JSON_VALUE,
					method= RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user){
		System.out.println("User details: "+user);
		
		User tempUser = userRepository.findOne(user.getEmail());
		if(tempUser != null) {
			if(user.getPassword().equals(tempUser.getPassword())) {
				return new ResponseEntity<>(tempUser,HttpStatus.OK);
			}
		}
		return new ResponseEntity <> (HttpStatus.UNAUTHORIZED);
	}
}
