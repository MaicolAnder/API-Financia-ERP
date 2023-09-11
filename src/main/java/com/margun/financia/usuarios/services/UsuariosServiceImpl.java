package com.margun.financia.usuarios.services;

import com.margun.financia.commons.helpers.MapperObject;
import com.margun.financia.commons.helpers.Utils;
import com.margun.financia.usuarios.dto.UsuarioDTO;
import com.margun.financia.usuarios.persistence.repositories.UsuariosRepository;
import com.margun.financia.usuarios.persistence.models.Usuarios;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Logical Implements for Usuarios domain
 * @author Miguel A Tunubalá
 */
@Service
public class UsuariosServiceImpl implements UsuariosService {

    /**
     * DAO of Usuarios model for access to database
     */
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuarios> users = (List<Usuarios>) usuariosRepository.findAll();
        return MapperObject.mapList(users, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO findById(Long id){
        Optional<Usuarios> usuariosEntity = usuariosRepository.findById(id);
        if (usuariosEntity.isPresent()) {
            return MapperObject.map(usuariosEntity.get(), UsuarioDTO.class);
        }
        return null;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO dto) {
        Usuarios usuarios = MapperObject.map(dto, Usuarios.class);

        usuarios.setFecha_modificacion(Utils.getDate());
        usuarios.setFecha_creacion(Utils.getDate());

        return MapperObject.map(
                                usuariosRepository.save(usuarios),
                                UsuarioDTO.class
                         );
    }

    @Override
    public UsuarioDTO update(UsuarioDTO dto, Long id) {

        Optional<Usuarios> usuariosEntity = usuariosRepository.findById(id);
        if (usuariosEntity.isPresent()) {
            usuariosEntity.get().setUsuario(dto.getUsuario());
            usuariosEntity.get().setClave(dto.getClave());
            usuariosEntity.get().setContrasena(dto.getContrasena());
            usuariosEntity.get().setFecha_modificacion(Utils.getDate());

            Usuarios updatedUsers = usuariosRepository.save(usuariosEntity.get());
            return MapperObject.map(updatedUsers, UsuarioDTO.class);

        }
        return  null;
    }

    @Override
    public UsuarioDTO delete(Long id) {

        Optional<Usuarios> usuariosEntity = usuariosRepository.findById(id);
        if (usuariosEntity.isPresent()) {
            usuariosRepository.deleteById(usuariosEntity.get().getId_usuario());
            return MapperObject.map(usuariosEntity.get(), UsuarioDTO.class);
        }
        return null;
    }
}
