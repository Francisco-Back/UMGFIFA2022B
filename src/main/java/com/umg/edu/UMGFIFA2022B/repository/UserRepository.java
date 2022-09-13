package com.umg.edu.UMGFIFA2022B.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umg.edu.UMGFIFA2022B.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
     
	
}

