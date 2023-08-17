package com.margun.financia.usuarios.services;

import com.margun.financia.usuarios.persistence.models.Usuarios;
import com.margun.financia.usuarios.responses.UsuarioResponseRest;
import org.springframework.http.ResponseEntity;

public interface UsuariosService {

    public ResponseEntity<UsuarioResponseRest> findAll();

    public ResponseEntity<UsuarioResponseRest> findById(Long id);

    ResponseEntity<UsuarioResponseRest> save(Usuarios usuarios);
}
