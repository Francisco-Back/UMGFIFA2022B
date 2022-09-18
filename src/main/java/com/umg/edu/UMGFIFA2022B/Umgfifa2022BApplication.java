package com.umg.edu.UMGFIFA2022B;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Umgfifa2022BApplication {

	@Bean
	public PasswordEncoder passworEncoder(){
		
		return new BCryptPasswordEncoder();
				
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Umgfifa2022BApplication.class, args);
	}

}
