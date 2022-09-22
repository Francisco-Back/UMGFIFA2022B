package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;

public interface ImUserService {

	List<Usuario> SetUser();

	Usuario ObtenerUsuario(Long Id);

	List<Usuario> Correo(String c) throws Exception;

}
