package com.umg.edu.UMGFIFA2022B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/User")
public class UserController {
	@Autowired	
	private final UserService userservice;
	@Autowired
	CloudinaryService cloudinaryService;
	
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}
	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody  UserlnDTO userlnDTO  ) {
		return new ResponseEntity<>(userservice.createUser(userlnDTO),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/Subir")
	public ResponseEntity<Map> upload(@RequestParam MultipartFile multipartFile) throws IOException{
		Map result = cloudinaryService.upload(multipartFile);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<?> setUser() {
		return ResponseEntity.ok(userservice.SetUser());
	}
<<<<<<< HEAD
	@CrossOrigin(origins = "*")
	@GetMapping("/search/{CUser}")
	public ResponseEntity<?> SearchEmail(@PathVariable("CUser") String CUser) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(userservice.Correodd(CUser));
	}
=======
>>>>>>> parent of b4888e7 (SearchEmailUser)
	
	
	
	
}

