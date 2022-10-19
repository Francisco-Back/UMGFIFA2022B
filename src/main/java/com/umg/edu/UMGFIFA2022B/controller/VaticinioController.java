package com.umg.edu.UMGFIFA2022B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.umg.edu.UMGFIFA2022B.TSecurity.DTO.Mensaje;
import com.umg.edu.UMGFIFA2022B.entity.VaticinioAuxEntity;
import com.umg.edu.UMGFIFA2022B.entity.VaticinioEntity;
import com.umg.edu.UMGFIFA2022B.services.VaticinioService;

@RestController
@RequestMapping("/api/Vaticinio")
public class VaticinioController {
	@Autowired	
	private  VaticinioService vaticinioService ;
	
	@PostMapping("/Send")
	public ResponseEntity<?> SenRabbit(@RequestBody  VaticinioAuxEntity vaticinioAuxEntity) {
		     
		
		if(vaticinioAuxEntity!=null) {
			vaticinioService.SenRabbit(vaticinioAuxEntity);
			return new ResponseEntity<>(new Mensaje("Mensaje Enviado"),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(new Mensaje("Mensaje no enviado"),HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
	@GetMapping("/ListarVat/{IDLigas}/{VPartido}")
	public ResponseEntity<?> ListarVat(@PathVariable("IDLigas") Long  LigasID,@PathVariable("VPartido") Long  VPartido) {
		             List<VaticinioEntity> gt= vaticinioService.ListarVat(LigasID, VPartido);
		
		if (gt==null) {
			
			 return  new ResponseEntity <>(new Mensaje("No encontrada "),HttpStatus.NOT_FOUND);
			
		}else {
			return  new ResponseEntity<>(gt, HttpStatus.OK);
		
		}
		
	}
	
	@GetMapping("/SearchVat/{IDVats}")
	public ResponseEntity<?> SearchVat(@PathVariable("IDVats") Long  IDVats) {
		Optional<VaticinioEntity> gt = vaticinioService.SearchVat(IDVats);   
		
		if (gt==null) {
			
			 return  new ResponseEntity <>(new Mensaje("No encontrada "),HttpStatus.NOT_FOUND);
			
		}else {
			return  new ResponseEntity<>(gt, HttpStatus.OK);
		
		}
		
	}
	@GetMapping("/SearchPartido/{UsParIDerID}")
	public ResponseEntity<?> SearchPartido(@PathVariable("UsParIDerID") Long  UsParIDerID) {
		List<VaticinioEntity> gt = vaticinioService.SearchPartido(UsParIDerID);   
		
		if (gt==null) {
			
			 return  new ResponseEntity <>(new Mensaje("No encontrada "),HttpStatus.NOT_FOUND);
			
		}else {
			return  new ResponseEntity<>(gt, HttpStatus.OK);
		
		}
		
	}
	
	@GetMapping("/SearchAll/{UserID}")
	public ResponseEntity<?> SearchAllUser(@PathVariable("UserID") Long  UserID) {
		List<VaticinioEntity> gt = vaticinioService.SearchAll(UserID); 
		
		if (gt==null) {
			
			 return  new ResponseEntity <>(new Mensaje("No encontrada "),HttpStatus.NOT_FOUND);
			
		}else {
			return  new ResponseEntity<>(gt, HttpStatus.OK);
		
		}
		
	}
	
	
	@PatchMapping("/Update/Ranking/{ID}/{ranking}")
	public ResponseEntity<?>  Ranking(@PathVariable("ID") Long ID ,
			@PathVariable("ranking") int  ranking){
		
		vaticinioService.UpdateRanking(ID, ranking);
	
		return  new ResponseEntity<>(new Mensaje("User Liga Update"),HttpStatus.OK);
	
	}
	
	

}
