package com.margun.financia.usuarios.services;

import com.margun.financia.commons.helpers.Utils;
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
    public ResponseEntity<UsuarioResponseRest> findAll() {
        UsuarioResponseRest response = new UsuarioResponseRest();
        try {
            List<Usuarios> usuarios = (List<Usuarios>) usuariosRepository.findAll();
            response.getUsuariosResponse().setUsuarios(usuarios);
            response.setMetadata("success");
        } catch (Exception e){
            response.setMetadata(e.getMessage(),"500");
            return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UsuarioResponseRest> findById(Long id){
        UsuarioResponseRest response = new UsuarioResponseRest();
        List<Usuarios> list = new ArrayList<>();
        try{
            Optional<Usuarios> usuariosEntity = usuariosRepository.findById(id);
            if (usuariosEntity.isPresent()){
                list.add(usuariosEntity.get());
                response.getUsuariosResponse().setUsuarios(list);
                response.setMetadata("success");
            } else {
                response.setMetadata("Data not found","400", Utils.getCurrenDate());
                return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            response.setMetadata(e.getMessage(),"500", Utils.getCurrenDate());
            return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UsuarioResponseRest> save(Usuarios usuarios) {
        UsuarioResponseRest response = new UsuarioResponseRest();
        List<Usuarios> list = new ArrayList<>();
        try{
            usuarios.setFecha_modificacion(Utils.getDate());
            usuarios.setFecha_creacion(Utils.getDate());

            Usuarios usuarioSaved = usuariosRepository.save(usuarios);
            if (usuarioSaved != null){
                list.add(usuarioSaved);
                response.getUsuariosResponse().setUsuarios(list);
                response.setMetadata("success", "201");
            } else {
                response.setMetadata("Data not found","400");
                return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            response.setMetadata(e.getMessage(),"500", Utils.getCurrenDate());
            return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
