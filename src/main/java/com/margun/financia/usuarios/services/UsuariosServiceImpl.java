package com.margun.financia.usuarios.services;

import com.margun.financia.commons.helpers.MapperObject;
import com.margun.financia.commons.helpers.Utils;
import com.margun.financia.usuarios.dto.UsuarioDTO;
import com.margun.financia.usuarios.persistence.repositories.UsuariosRepository;
import com.margun.financia.usuarios.persistence.models.Usuarios;
import com.margun.financia.usuarios.responses.UsuarioResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;
    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuarios> users = (List<Usuarios>) usuariosRepository.findAll();
        return MapperObject.mapList(users, UsuarioDTO.class);
    }

    @Override
    public List<UsuarioDTO> findById(Long id){
        List<UsuarioDTO> list = new ArrayList<>();

        Optional<Usuarios> usuariosEntity = usuariosRepository.findById(id);
        if (usuariosEntity.isPresent()) {
            UsuarioDTO dto = MapperObject.map(usuariosEntity, UsuarioDTO.class);
            list.add(dto);
        }
        return  list;
    }

    @Override
    public List<UsuarioDTO> save(UsuarioDTO dto) {
        List<UsuarioDTO> list = new ArrayList<>();
        dto.setFecha_modificacion(Utils.getDate());
        Usuarios usuarios = MapperObject.map(dto, Usuarios.class);
        usuarios.setFecha_creacion(Utils.getDate());

        UsuarioDTO save = MapperObject.map(
                                usuariosRepository.save(usuarios),
                                UsuarioDTO.class
                         );
        if (save != null){
            list.add(save);
        }
        return  list;
    }
}
