package com.margun.financia.usuarios.services;

import com.margun.financia.usuarios.dto.UsuarioDTO;
import java.util.List;

public interface UsuariosService {

    public List<UsuarioDTO> findAll();

    public List<UsuarioDTO> findById(Long id);

    List<UsuarioDTO> save(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> update(UsuarioDTO usuarioDTO, Long id);

    List<UsuarioDTO> delete(Long id);
}
