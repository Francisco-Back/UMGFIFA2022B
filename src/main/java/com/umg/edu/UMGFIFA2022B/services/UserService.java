package com.umg.edu.UMGFIFA2022B.services;

import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.repository.UserRepository;

@Service
public class UserService {

	
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	
	
}
