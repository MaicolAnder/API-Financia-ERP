package com.margun.financia.services;

import com.margun.financia.response.UsuarioResponseRest;
import org.springframework.http.ResponseEntity;

public interface UsuariosServices {

    public ResponseEntity<UsuarioResponseRest> search();
}
