package com.margun.financia.usuarios.responses;

import com.margun.financia.commons.responses.ResponseRest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponseRest extends ResponseRest {
    private UsuariosResponse usuariosResponse = new UsuariosResponse();

}
