package com.umg.edu.UMGFIFA2022B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umg.edu.UMGFIFA2022B.services.VaticinioService;

@RestController
@RequestMapping("/api/Vaticinio")
public class VaticinioController {
	@Autowired	
	private  VaticinioService vaticinioController ;

}
