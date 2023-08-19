package com.margun.financia.usuarios.responses;

import com.margun.financia.usuarios.dto.UsuarioDTO;
import com.margun.financia.usuarios.persistence.models.Usuarios;
import lombok.Data;

import java.util.List;

@Data
public class UsuariosResponse {
    private List<UsuarioDTO> usuarios;
}
