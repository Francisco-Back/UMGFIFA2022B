package com.umg.edu.UMGFIFA2022B.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umg.edu.UMGFIFA2022B.security.entity.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String Email);
}