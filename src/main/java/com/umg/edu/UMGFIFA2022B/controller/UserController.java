package com.umg.edu.UMGFIFA2022B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umg.edu.UMGFIFA2022B.services.UserService;
import com.umg.edu.UMGFIFA2022B.services.dto.UserlnDTO;

@RestController
@RequestMapping("/api/User")
public class UserController {
	@Autowired	
	private final UserService userservice;

	
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody  UserlnDTO userlnDTO  ) {
		return new ResponseEntity<>(userservice.createUser(userlnDTO),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<?> setUser() {
		return ResponseEntity.ok(userservice.SetUser());
	}
	
	
	
	
}

