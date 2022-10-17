package com.umg.edu.UMGFIFA2022B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umg.edu.UMGFIFA2022B.TSecurity.DTO.Mensaje;
import com.umg.edu.UMGFIFA2022B.entity.PartidoEntity;
import com.umg.edu.UMGFIFA2022B.services.PartidosService;
@RestController
@RequestMapping("/api/Partidos")
public class PartidosController {
	@Autowired
	private PartidosService partidosService;
	
	
	
	@PatchMapping("/Update/{Mar1}/{Mar2}/{Col}")
	public ResponseEntity<?>  UpdateMarcador(@PathVariable("Mar1") int Mar1 ,
			@PathVariable("Mar2") int Mar2 ,
			@PathVariable("Col") Long Col){
		partidosService.Resultados(Mar1, Mar2, Col);
		
		
		return  new ResponseEntity<>(new Mensaje("Resultado Ingresado"),HttpStatus.OK);
	
	}
	
	@GetMapping
	public ResponseEntity<?> SetPartido() {
		
		return  ResponseEntity.ok(partidosService.Partidos());

	}
	
	@GetMapping("/Search/{Col}")
	public ResponseEntity<?> Searchpartido(@PathVariable(value = "Col") Long Col) {
		PartidoEntity gt=new PartidoEntity();
		
		if(Col!=null) {
		gt= partidosService.Search(Col);
               if(gt!=null) {
            	   return new ResponseEntity<>(gt,HttpStatus.OK);
               }else {
            	   return new ResponseEntity<>(new Mensaje("No encontrado"),HttpStatus.NOT_FOUND);
               }
			
		}else {
			return new ResponseEntity<>(new Mensaje("No encontrado"),HttpStatus.NOT_FOUND);
		}
		
	}
	
	

	
	
	
	
	
}
