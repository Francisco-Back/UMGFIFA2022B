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
import com.umg.edu.UMGFIFA2022B.entity.MailForm;
import com.umg.edu.UMGFIFA2022B.services.SendMailService;
import com.umg.edu.UMGFIFA2022B.services.UserService;


@RestController
@RequestMapping("/api/User")
public class UserController {
	@Autowired	
	private  UserService userservice;
	  @Autowired
	    private SendMailService mailService;

	@GetMapping
	public ResponseEntity<?> setUser() {
		if(userservice.SetUser()!=null) {
			return new ResponseEntity<>(this.userservice.SetUser(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new Mensaje("Lista Vacia"),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/search/{CUser}")
	public ResponseEntity<?> SearchEmail(@PathVariable("CUser") String CUser) throws Exception{
		
		if(userservice.Correo(CUser)!=null) {
			return new ResponseEntity<>(this.userservice.Correo(CUser),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new Mensaje("Correo No Encontrado"),HttpStatus.NOT_FOUND);
		
	
	}
	}
	@GetMapping("/Dsearch/{CUser}")
	public ResponseEntity<?> UserID(@PathVariable("CUser") String CUser) throws Exception{
		
		if(userservice.UserID(CUser)!=null) {
			return new ResponseEntity<>(this.userservice.UserID(CUser),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new Mensaje("Correo No Encontrado"),HttpStatus.NOT_FOUND);
		
	
	}
	}
	
	@PostMapping("/Invitacion/{ID}/{Cinvitado}")
	public ResponseEntity<?> Invitacion(@PathVariable("ID") Long ID , @PathVariable("Cinvitado") String Cinvitado){
		
		if( ID !=null && Cinvitado !=null ) {
			return new ResponseEntity<>(this.mailService.SenMail(ID,Cinvitado),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new Mensaje("Correo no Enviado N"), HttpStatus.NOT_FOUND);
		}
		
		
		
	}
	
	

	
	
	
	
	
	
}

