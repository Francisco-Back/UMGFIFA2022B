package com.umg.edu.UMGFIFA2022B.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
private  LigaServices ligaServices;
	
	@PostMapping("/{UserID}")
	public ResponseEntity<?> createLigas(@PathVariable(value = "UserID") Long UserID,@RequestBody  LigasInDTO ligasInDTO) {
		
		return new ResponseEntity<>(ligaServices.createLiga(UserID, ligasInDTO),HttpStatus.CREATED);
	}

	
	@GetMapping
	public ResponseEntity<?> setLiga() {
		
		return  ResponseEntity.ok(ligaServices.SetLigas());

	}
	
	@GetMapping("/LigasUser/{IDLigas}")
	public Optional<LigasEntity> findAllByLigas(@PathVariable("IDLigas") Long  LigasID) {
		return this.ligaServices.findAllByLigas(LigasID);

	}
	
	@DeleteMapping("/Delete/{IdLiga}")
	public ResponseEntity<?> EliminarLiga(@PathVariable Long IdLiga){
		
		ligaServices.EliminarLiga(IdLiga);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/UserT/{UserID}")
	public ResponseEntity<?> LigaUser(@PathVariable("UserID") Long  UserID) {
		return  new ResponseEntity<>(this.ligaServices.LigaUser(UserID), HttpStatus.OK);
				
	
	}
	
}

