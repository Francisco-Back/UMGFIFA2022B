package com.umg.edu.UMGFIFA2022B.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.services.UserService;
import com.umg.edu.UMGFIFA2022B.services.dto.UserlnDTO;

@RestController
@RequestMapping("/UserCreate")
public class UserController {

	
	private final UserService userservice;

	
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}
	@CrossOrigin(origins = "*")
	@PostMapping
	public UserEntity createUser(@RequestBody  UserlnDTO userlnDTO  ) {
		return userservice.createUser(userlnDTO);
	}
	
	
	@GetMapping
	public List<UserEntity> setUser() {
		return this.userservice.SetUser();
	}
	
	
	
}

