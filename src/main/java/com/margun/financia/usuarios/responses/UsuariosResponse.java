package com.margun.financia.usuarios.responses;

import com.margun.financia.usuarios.dto.UsuarioDTO;
import lombok.Data;

import java.util.List;

@Data
public class UsuariosResponse {
    private List<UsuarioDTO> usuarios;
}
