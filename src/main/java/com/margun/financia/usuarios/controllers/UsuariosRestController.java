package com.margun.financia.usuarios.controllers;

import com.margun.financia.commons.helpers.MapperObject;
import com.margun.financia.commons.helpers.Utils;
import com.margun.financia.usuarios.dto.UsuarioDTO;
import com.margun.financia.usuarios.persistence.models.Usuarios;
import com.margun.financia.usuarios.responses.UsuarioResponseRest;
import com.margun.financia.usuarios.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuariosRestController {

    @Autowired
    private UsuariosService services;

    @GetMapping
    public ResponseEntity<UsuarioResponseRest> findAllUsuarios(){
        UsuarioResponseRest response = new UsuarioResponseRest();
        HttpStatus status;
        try {
            List<UsuarioDTO> dto = this.services.findAll();
            if (!dto.isEmpty()){
                status = HttpStatus.OK;
                response.setMetadata("success");
            } else {
                response.setMetadata("Data not found", "400");
                status = HttpStatus.NOT_FOUND;
            }
            response.getUsuariosResponse().setUsuarios(dto);
        } catch (Exception e) {
            response.setMetadata(e.getMessage(), "500");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<UsuarioResponseRest>(response, status);

    }

    @GetMapping("/{id}")
    public  ResponseEntity<UsuarioResponseRest> findByIdUsuarios(@PathVariable Long id){
        UsuarioResponseRest response = new UsuarioResponseRest();
        HttpStatus status;
        try{
            List<UsuarioDTO> list = this.services.findById(id);
            if (!list.isEmpty()){
                response.getUsuariosResponse().setUsuarios(list);
                response.setMetadata("success");
                status = HttpStatus.OK;
            } else {
                response.setMetadata("Data not found", "400");
                status = HttpStatus.NOT_FOUND;
            }
        } catch (Exception e){
            response.setMetadata(e.getMessage(), "500");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<UsuarioResponseRest>(response, status);
    }

    @PostMapping
    public  ResponseEntity<UsuarioResponseRest> saveUsuario(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioResponseRest response = new UsuarioResponseRest();
        HttpStatus status;
        try{
            List<UsuarioDTO> list = this.services.save(usuarioDTO);
            if (!list.isEmpty()){
                response.getUsuariosResponse().setUsuarios(list);
                response.setMetadata("success");
                status = HttpStatus.CREATED;
            } else {
                response.setMetadata("Data not found", "400");
                status = HttpStatus.NOT_FOUND;
            }
        } catch (Exception e){
            response.setMetadata(e.getMessage(), "500");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<UsuarioResponseRest>(response, status);
    }
}
