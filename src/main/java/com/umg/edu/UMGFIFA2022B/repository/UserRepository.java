package com.umg.edu.UMGFIFA2022B.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@Query(value = "SELECT * FROM usuarios WHERE correo =:correo", nativeQuery = true)
	public List<UserEntity> findByCorreo(String correo);
	
       
}

 