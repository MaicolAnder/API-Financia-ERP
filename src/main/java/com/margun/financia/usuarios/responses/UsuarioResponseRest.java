package com.margun.financia.usuarios.responses;

import com.margun.financia.commons.responses.ResponseRest;
import lombok.Getter;
import lombok.Setter;

/**
 * Rest response for Usuarios
 * @author Miguel A Tunubalá
 */
@Getter
@Setter
public class UsuarioResponseRest extends ResponseRest {
    private UsuariosResponse usuariosResponse  = new UsuariosResponse();
}
