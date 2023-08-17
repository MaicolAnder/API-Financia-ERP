package com.margun.financia.usuarios.controllers;

import com.margun.financia.usuarios.persistence.models.Usuarios;
import com.margun.financia.usuarios.responses.UsuarioResponseRest;
import com.margun.financia.usuarios.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuariosRestController {

    @Autowired
    private UsuariosService services;
    @GetMapping
    public ResponseEntity<UsuarioResponseRest> findAllUsuarios(){
        return this.services.findAll();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<UsuarioResponseRest> findByIdUsuarios(@PathVariable Long id){
        return this.services.findById(id);
    }

    @PostMapping
    public  ResponseEntity<UsuarioResponseRest> saveUsuario(@RequestBody Usuarios usuarios){
        return  this.services.save(usuarios);
    }
}
