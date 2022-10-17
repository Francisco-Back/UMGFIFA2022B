package com.umg.edu.UMGFIFA2022B.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.repository.VaticinioRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImVaticinioServices;

@Service
public class VaticinioService implements ImVaticinioServices {
	   @Autowired
	private VaticinioRepository vaticinioRepository; 
	   
	   
	   
	   
	   
}
