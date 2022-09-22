package com.umg.edu.UMGFIFA2022B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umg.edu.UMGFIFA2022B.TSecurity.DTO.Mensaje;
import com.umg.edu.UMGFIFA2022B.services.UserLigasService;

@RestController
@RequestMapping("/api/UserLigas")
public class UserLigasController  {
	@Autowired	
	private  UserLigasService userligasService;

	@PostMapping("/UnionLiga/{UserID}/{LigasID}" )
	public ResponseEntity<?> UnionLiga(@PathVariable("UserID") Long UserID,@PathVariable("LigasID") Long LigasID){
		//userligasService.UnionLiga(UserID, LigasID);
		if(userligasService.UnionLiga(UserID, LigasID)==null) {
			return new ResponseEntity <>(new Mensaje("Union Fail"),HttpStatus.NOT_FOUND);
		}else {
			
			return new ResponseEntity <>(new Mensaje("Union Exitosa"),HttpStatus.CREATED);
		}
	}

	@GetMapping("/searchLiga/{LigasID}")
	public ResponseEntity<?> LigasPro(@PathVariable("LigasID") Long LigaID){
	if(userligasService.SearchIdLiga(LigaID)!=null) {
		return new ResponseEntity<>(this.userligasService.SearchIdLiga(LigaID),HttpStatus.OK);
	}else {
		return new ResponseEntity<>(new Mensaje("Liga No encontrada"), HttpStatus.NOT_FOUND);
	}
	}
	
	@GetMapping("/searchuser/{UserID}")
	public ResponseEntity<?> Ligauser(@PathVariable("UserID") Long UserID){
		if(userligasService.SearchIdUser(UserID)!=null) {
			return new ResponseEntity<>(this.userligasService.SearchIdUser(UserID),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new Mensaje("Liga No encontrada"), HttpStatus.NOT_FOUND);
		}
	}
	
	

	@GetMapping("/Estado/{EsLiga}")
	public ResponseEntity<?> EstadoLiga(@PathVariable("EsLiga") int EsLiga){
		
		if(userligasService.Estados(EsLiga)!=null) {
			return new ResponseEntity<>(userligasService.Estados(EsLiga), HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(new Mensaje("Lista Vacia"), HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PatchMapping("/update/Estado/{IdUnio}/{Estado}")
	public ResponseEntity<?>  UpdateEstados(@PathVariable("IdUnio") Long IdUnio ,
			@PathVariable("Estado") int  Estado){
		
		userligasService.updateEstados(IdUnio, Estado);
	
		return  new ResponseEntity<>(new Mensaje("User Liga Update"),HttpStatus.NO_CONTENT);
	
	}
	
	
	
	
	
	
}
