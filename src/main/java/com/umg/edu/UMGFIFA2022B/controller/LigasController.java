package com.umg.edu.UMGFIFA2022B.controller;

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
import com.umg.edu.UMGFIFA2022B.services.LigaServices;
import com.umg.edu.UMGFIFA2022B.services.dto.LigasInDTO;


@RestController
@RequestMapping("/api/Ligas")
public class LigasController {
	
@Autowired	
private  LigaServices ligaServices;
	// se crea liga
	@PostMapping("/Create/{UserID}")
	public ResponseEntity<?> createLigas(@PathVariable(value = "UserID") Long UserID,@RequestBody  LigasInDTO ligasInDTO) {
		if(ligaServices.createLiga(UserID, ligasInDTO)!=null) {
			return new ResponseEntity<>(new Mensaje("Liga Creada"),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(new Mensaje("Liga Fail"),HttpStatus.NOT_FOUND);
		}
		
	}

	// se obtiene todas la ligas
	@GetMapping
	public ResponseEntity<?> setLiga() {
		
		return  ResponseEntity.ok(ligaServices.SetLigas());

	}
	
	//se obtiene liga por id
	
	@GetMapping("/LigasUser/{IDLigas}")
	public ResponseEntity<?> ObtenerLiga(@PathVariable("IDLigas") Long  LigasID) {
		
		if (ligaServices.ObtenerLiga(LigasID)==null) {
			
			 return  new ResponseEntity <>(new Mensaje("No encontrada "),HttpStatus.NOT_FOUND);
			
		}else {
			return  new ResponseEntity<>(this.ligaServices.ObtenerLiga(LigasID), HttpStatus.OK);
		
		}
		
	}
	
	//se elimina liga
	@DeleteMapping("/Delete/{IdLiga}")
	public ResponseEntity<?> EliminarLiga(@PathVariable Long IdLiga){
		
		
		 ligaServices.EliminarLiga(IdLiga);
		
		return new ResponseEntity <>(new Mensaje("Liga Eliminada "),HttpStatus.OK);
	}
	
	
	//se obtiene liga por userID
	@GetMapping("/UserT/{UserID}")
	public ResponseEntity<?> LigaUser(@PathVariable("UserID") Long  UserID) {
		
		if (ligaServices.LigaUser(UserID)==null) {
			 return  new ResponseEntity <>(new Mensaje("No encontrada "),HttpStatus.NOT_FOUND);
			
		}else {
			return  new ResponseEntity<>(this.ligaServices.LigaUser(UserID), HttpStatus.OK);
		}
		
				
	
	}
	//se obtiene liga por userID
	@GetMapping("/Verificador/{LigaID}")
	public ResponseEntity<?> Verificador(@PathVariable("LigaID") Long  LigaID) {
		
		if (ligaServices.Verificador(LigaID)==null) {
			 return  new ResponseEntity <>(new Mensaje("No encontrada "),HttpStatus.NOT_FOUND);
			
		}else {
			return  new ResponseEntity<>(this.ligaServices.Verificador(LigaID), HttpStatus.OK);
		}

	}
	
}

