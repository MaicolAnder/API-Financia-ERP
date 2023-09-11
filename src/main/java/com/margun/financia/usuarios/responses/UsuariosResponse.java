package com.margun.financia.usuarios.responses;

import com.margun.financia.usuarios.dto.UsuarioDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuariosResponse {

    private List<UsuarioDTO> usuarios = new ArrayList<>();

    public void setUsuarios(List<UsuarioDTO> usuario) {
        this.usuarios = usuario;
    }

    public void setUsuarios(UsuarioDTO usuarioDTO) {
        this.usuarios.add(usuarioDTO);
    }

}
