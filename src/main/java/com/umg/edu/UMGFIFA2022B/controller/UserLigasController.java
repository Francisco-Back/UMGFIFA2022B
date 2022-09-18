package com.umg.edu.UMGFIFA2022B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umg.edu.UMGFIFA2022B.services.UserLigasService;
import com.umg.edu.UMGFIFA2022B.services.dto.UserLigasDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/UnionLiga")
public class UserLigasController {
	@Autowired	
	private final UserLigasService userligasService;

	public UserLigasController(UserLigasService userligasService) {
		this.userligasService = userligasService;
	}

	@PostMapping("/{UserID}/{LigasID}" )
	public ResponseEntity<?> UnionLiga(@PathVariable Long UserID,@PathVariable Long LigasID, @RequestBody UserLigasDTO  dto ){
		return new ResponseEntity<>(userligasService.UnionLiga(UserID, LigasID, dto),HttpStatus.CREATED);
	}
}
