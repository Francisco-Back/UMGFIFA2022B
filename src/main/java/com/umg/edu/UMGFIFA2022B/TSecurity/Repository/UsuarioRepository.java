package com.umg.edu.UMGFIFA2022B.TSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;

import java.util.List;
import java.util.Optional;

@Component
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  
    boolean existsByEmail(String Email);


	Optional<Usuario> findByEmail(String email);
	
	@Query(value = "SELECT * FROM usuario WHERE email =:Email", nativeQuery = true)
	List<Usuario> Corro(String Email);
	
}