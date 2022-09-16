package com.umg.edu.UMGFIFA2022B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.services.CloudinaryService;
import com.umg.edu.UMGFIFA2022B.services.UserService;
import com.umg.edu.UMGFIFA2022B.services.dto.UserlnDTO;

@RestController
@RequestMapping("/UserCreate")
@CrossOrigin(*)
public class UserController {

	
	private final UserService userservice;
	@Autowired
	CloudinaryService cloudinaryService;
	
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}
	//@CrossOrigin(origins = "*")
	@PostMapping
	public UserEntity createUser(@RequestBody  UserlnDTO userlnDTO  ) {
		return userservice.createUser(userlnDTO);
	}

	@PostMapping("/Subir")
	public ResponseEntity<Map> upload(@RequestParam MultipartFile multipartFile) throws IOException{
		Map result = cloudinaryService.upload(multipartFile);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@GetMapping
	public List<UserEntity> setUser() {
		return this.userservice.SetUser();
	}
	
	
	
}

