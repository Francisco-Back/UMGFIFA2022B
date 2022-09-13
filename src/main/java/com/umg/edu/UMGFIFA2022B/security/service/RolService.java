package com.umg.edu.UMGFIFA2022B.security.service;

import com.umg.edu.UMGFIFA2022B.security.entity.Rol;
import com.umg.edu.UMGFIFA2022B.security.enums.RolNombre;
import com.umg.edu.UMGFIFA2022B.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
}
