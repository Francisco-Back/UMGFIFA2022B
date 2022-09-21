package com.umg.edu.UMGFIFA2022B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umg.edu.UMGFIFA2022B.TSecurity.DTO.Mensaje;
import com.umg.edu.UMGFIFA2022B.entity.Enum.EstadoLigas;
import com.umg.edu.UMGFIFA2022B.services.UserLigasService;

@RestController
@RequestMapping("/api")
public class UserLigasController  {
	@Autowired	
	private  UserLigasService userligasService;

	@PostMapping("/UnionLiga/{UserID}/{LigasID}" )
	public ResponseEntity<?> UnionLiga(@PathVariable("UserID") Long UserID,@PathVariable("LigasID") Long LigasID){
		//userligasService.UnionLiga(UserID, LigasID);
		if(userligasService.UnionLiga(UserID, LigasID)==null) {
		return new ResponseEntity <>(new Mensaje("Union Exitosa"),HttpStatus.CREATED);
		}else {
			return new ResponseEntity <>(new Mensaje("Union Fail"),HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/Ligas/{LigaID}")
	public ResponseEntity<?> LigasPro(@PathVariable("LigasID") Long LigaID){
	if(userligasService.SearchIdLiga(LigaID)==null) {
		return new ResponseEntity<>(this.userligasService.SearchIdLiga(LigaID),HttpStatus.OK);
	}else {
		return new ResponseEntity<>(new Mensaje("Liga No encontrada"), HttpStatus.NOT_FOUND);
	}
	}
	
	@GetMapping("/Ligas/{UserID}")
	public ResponseEntity<?> Ligauser(@PathVariable("UserID") Long UserID){
		if(userligasService.SearchIdUser(UserID)==null) {
			return new ResponseEntity<>(this.userligasService.SearchIdUser(UserID),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new Mensaje("Liga No encontrada"), HttpStatus.NOT_FOUND);
		}
	}
	
	

	@GetMapping("/Estado/{EsLiga}")
	public ResponseEntity<?> EstadoLiga(@PathVariable("EsLiga") EstadoLigas EsLiga){
		
		if(userligasService.Estados(EsLiga)==null) {
			return new ResponseEntity<>(userligasService.Estados(EsLiga), HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(new Mensaje("Fallo Cambio Estado "), HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	
}
