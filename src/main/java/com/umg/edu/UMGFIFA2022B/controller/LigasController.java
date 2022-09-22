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

import com.umg.edu.UMGFIFA2022B.TSecurity.DTO.Mensaje;
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
		if(ligaServices.createLiga(UserID, ligasInDTO)!=null) {
			return new ResponseEntity<>(new Mensaje("Liga Creada"),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(new Mensaje("Liga Fail"),HttpStatus.NOT_FOUND);
		}
		
	}

	
	@GetMapping
	public ResponseEntity<?> setLiga() {
		
		return  ResponseEntity.ok(ligaServices.SetLigas());

	}
	
	@GetMapping("/LigasUser/{IDLigas}")
	public ResponseEntity<?> findAllByLigas(@PathVariable("IDLigas") Long  LigasID) {
		
		if (this.ligaServices.findAllByLigas(LigasID)!=null) {
			return  new ResponseEntity<>(this.ligaServices.findAllByLigas(LigasID), HttpStatus.OK);
		}else {
			 return  new ResponseEntity <>(new Mensaje("No encontrada "),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/Delete/{IdLiga}")
	public ResponseEntity<?> EliminarLiga(@PathVariable Long IdLiga){
		
		
		 ligaServices.EliminarLiga(IdLiga);
		
		return new ResponseEntity <>(new Mensaje("Liga Eliminada "),HttpStatus.OK);
	}
	
	@GetMapping("/UserT/{UserID}")
	public ResponseEntity<?> LigaUser(@PathVariable("UserID") Long  UserID) {
		
		if (this.ligaServices.LigaUser(UserID)!=null) {
			return  new ResponseEntity<>(this.ligaServices.LigaUser(UserID), HttpStatus.OK);
		}else {
			 return  new ResponseEntity <>(new Mensaje("No encontrada "),HttpStatus.NOT_FOUND);
		}
		
				
	
	}
	
}

