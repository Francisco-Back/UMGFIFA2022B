package com.umg.edu.UMGFIFA2022B.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.services.LigaServices;
import com.umg.edu.UMGFIFA2022B.services.dto.LigasInDTO;


@RestController
@RequestMapping("/api/Ligas")
public class LigasController {
	
@Autowired	
private final LigaServices ligaServices;

	
	public LigasController(LigaServices ligaServices) {
		this.ligaServices = ligaServices;
	}
	
	
	
	@PostMapping("/{UserID}")
	public LigasEntity createLigas(@PathVariable(value = "UserID") Long UserID,@RequestBody  LigasInDTO ligasInDTO) {
		
		return ligaServices.createLiga(UserID, ligasInDTO);
	}

	
	@GetMapping
	public List<LigasEntity> setLiga() {
		return this.ligaServices.SetLigas();

	}
	
	@GetMapping("/LigasUser/{IDLigas}")
	public Optional<LigasEntity> LigasUser(@PathVariable("IDLigas") Long  LigasID) {
		return this.ligaServices.findAllByLigas(LigasID);

	}
}

