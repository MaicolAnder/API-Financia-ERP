package com.margun.financia.services;

import com.margun.financia.dao.UsuariosInterface;
import com.margun.financia.model.Usuarios;
import com.margun.financia.response.UsuarioResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosServicesImpl implements UsuariosServices {
    @Autowired
    private UsuariosInterface dao;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<UsuarioResponseRest> search() {
        UsuarioResponseRest response = new UsuarioResponseRest();
        try {
            List<Usuarios> usuarios = (List<Usuarios>) dao.findAll();
            response.getUsuariosResponse().setUsuarios(usuarios);
            response.setMetadata("ok","200","success");
        } catch (Exception e){
            response.setMetadata(e.getMessage(),"500","error");
            return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
    }
}
