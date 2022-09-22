package com.umg.edu.UMGFIFA2022B.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.umg.edu.UMGFIFA2022B.services.CloudinaryService;
import com.umg.edu.UMGFIFA2022B.services.UserService;
import com.umg.edu.UMGFIFA2022B.services.dto.Mensaje;
import com.umg.edu.UMGFIFA2022B.services.dto.UserlnDTO;

@CrossOrigin(origins = "/**")
@RestController
@RequestMapping("/api/User")
public class UserController {
	@Autowired	
	private final UserService userservice;
	@Autowired
	private CloudinaryService cloudinaryService;
	
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody  UserlnDTO userlnDTO  ) throws IOException {
		//Map result = cloudinaryService.upload(userlnDTO.getAvatar());
		return new ResponseEntity<>(userservice.createUser(userlnDTO),HttpStatus.CREATED);
	}
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException{
		BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
		if(bi==null){
			return new ResponseEntity(new Mensaje("Imagen no valida"), HttpStatus.BAD_REQUEST);
		}
		Map result = cloudinaryService.upload(multipartFile);
		String imagen = (String)result.get("public_id");
		return new ResponseEntity(imagen, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> setUser() {
		return ResponseEntity.ok(userservice.SetUser());
	}
	
	@GetMapping("/search/{CUser}")
	public ResponseEntity<?> SearchEmail(@PathVariable("CUser") String CUser) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(userservice.Correodd(CUser));
	}
	
	
	
	
}

