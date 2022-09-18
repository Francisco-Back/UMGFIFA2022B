package com.umg.edu.UMGFIFA2022B.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
<<<<<<< Updated upstream
	@Query(value = "SELECT * FROM usuarios WHERE Correo =:Correo", nativeQuery = true)
	public List<UserEntity> findByCorreo(String Correo);
	Optional<UserEntity> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
=======
	
	
	
	@Query(value = "SELECT * FROM usuarios WHERE correo =:correo", nativeQuery = true)
	public List<UserEntity> findByCorreo(String correo);
	
	@Query(value = "SELECT * FROM usuarios WHERE correo =:nombreUsuario", nativeQuery = true)
	List<UserEntity> findBynombreUsuario(String nombreUsuario);
	
	@Query(value = "SELECT nombre_usuario FROM usuarios WHERE nombre_usuario=:nombreUsuario", nativeQuery = true)
   public boolean existsBynombreUsuario(String nombreUsuario);
	
	@Query(value = "SELECT correo FROM usuarios WHERE correo =:Correo", nativeQuery = true)
>>>>>>> Stashed changes
    boolean existsByCorreo(String Correo);
}

 