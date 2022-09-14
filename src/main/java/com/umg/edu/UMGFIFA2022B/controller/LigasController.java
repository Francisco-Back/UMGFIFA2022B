package com.umg.edu.UMGFIFA2022B.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.services.LigaServices;
import com.umg.edu.UMGFIFA2022B.services.dto.LigasInDTO;


@RestController
@RequestMapping("/Ligas")
public class LigasController {
	
private final LigaServices ligaServices;

	
	public LigasController(LigaServices ligaServices) {
		this.ligaServices = ligaServices;
	}
	
	@PostMapping
	public LigasEntity createLigas(@RequestBody  LigasInDTO ligasInDTO  ) {
		return ligaServices.createLiga(ligasInDTO);
	}
	
	
	@GetMapping
	public List<LigasEntity> setLiga() {
		return this.ligaServices.SetLigas();

	}
	
	@GetMapping("/LigasUser/{objetoUser}")
	public Optional<LigasEntity> LigasUser(@PathVariable("objetoUser") UserEntity  UserID) {
		return this.ligaServices.findAllByLigas(UserID);

	}
}

