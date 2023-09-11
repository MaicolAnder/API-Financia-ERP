package com.margun.financia.usuarios.services;

import com.margun.financia.usuarios.dto.UsuarioDTO;
import java.util.List;

public interface UsuariosService {

    List<UsuarioDTO> findAll();

    UsuarioDTO findById(Long id);

    UsuarioDTO save(UsuarioDTO usuarioDTO);

    UsuarioDTO update(UsuarioDTO usuarioDTO, Long id);

    UsuarioDTO delete(Long id);
}
