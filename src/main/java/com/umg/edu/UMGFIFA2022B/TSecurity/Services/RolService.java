package com.umg.edu.UMGFIFA2022B.TSecurity.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Rol;
import com.umg.edu.UMGFIFA2022B.TSecurity.Repository.RolRepository;
import com.umg.edu.UMGFIFA2022B.TSecurity.enums.RolNombre;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
