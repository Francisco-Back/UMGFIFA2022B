package com.umg.edu.UMGFIFA2022B.Util;

import com.umg.edu.UMGFIFA2022B.security.entity.Rol;
import com.umg.edu.UMGFIFA2022B.security.enums.RolNombre;
import com.umg.edu.UMGFIFA2022B.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception{
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);

    }
}
