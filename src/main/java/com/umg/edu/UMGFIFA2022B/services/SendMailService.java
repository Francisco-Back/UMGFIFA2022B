package com.umg.edu.UMGFIFA2022B.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;
import com.umg.edu.UMGFIFA2022B.entity.MailForm;

@Service
public class SendMailService {
	
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserService userService;
    
    
    public String SenMail(Long ID,String Email) {
    	
    	try {
    	Usuario usuario=new Usuario();
    	usuario=userService.ObtenerUsuario(ID);
    	if(usuario !=null) {
    		String subject = "Invitación";
    	    String body = "Hola a sido invitado a formar parte de mi liga  "+
    		 "https://francisco-back.github.io/UMGFIFA2022/register/"+ID;
    	MailForm form =new MailForm();	
    	 form.setSubject(subject);
         form.setBody(body);
         form.setName(usuario.getNombre());
         form.setMail(usuario.getEmail());

         System.out.println(form.toString());
         String message = form.getBody() +"\n\nDatos de contacto: " +
                 "\nNombre: " + form.getName() + "\nE-mail: " + form.getMail();
    	
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom("UMGFIFA2022@gmail.com");//Datos
        mail.setTo(Email);//Correo Invitado
        mail.setSubject(subject);
        mail.setText(message);

        javaMailSender.send(mail);
    System.out.println("correo enviado");
        return "correo enviado";
    	}
    	} catch (NoSuchElementException e) {
    		System.out.println(e);
    		System.out.println("correo no enviado");
    		
		}
    	return "correo no enviado";
    }
    
}