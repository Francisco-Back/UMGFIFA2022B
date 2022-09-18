package com.umg.edu.UMGFIFA2022B.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@Query(value = "SELECT * FROM usuarios WHERE Correo =:Correo", nativeQuery = true)
	public List<UserEntity> findByCorreo(String Correo);
	Optional<UserEntity> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByCorreo(String Correo);
}

 