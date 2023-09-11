package com.margun.financia.usuarios.controllers;

import com.margun.financia.usuarios.dto.UsuarioDTO;
import com.margun.financia.usuarios.responses.UsuarioResponseRest;
import com.margun.financia.usuarios.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller Rest for access to Usuarios
 * @author Miguel A Tunubalá
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuariosRestController {

    @Autowired
    private UsuariosService services;

    /**
     *
     * @return ResponseEntity
     */
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
            UsuarioDTO user = this.services.findById(id);
            if (user != null){
                response.getUsuariosResponse().setUsuarios(user);
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
            UsuarioDTO user = this.services.save(usuarioDTO);
            response.getUsuariosResponse().setUsuarios(user);
            response.setMetadata("success");
            status = HttpStatus.CREATED;

        } catch (Exception e){
            response.setMetadata(e.getMessage(), "500");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<UsuarioResponseRest>(response, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseRest> updateUsuario(@RequestBody UsuarioDTO dto, @PathVariable Long id) {
        UsuarioResponseRest response = new UsuarioResponseRest();
        HttpStatus status;
        try{
            UsuarioDTO usuarioDTO = this.services.update(dto, id);
            if (usuarioDTO != null){
                response.getUsuariosResponse().setUsuarios(usuarioDTO);
                response.setMetadata("success");
                status = HttpStatus.OK;
            } else {
                response.setMetadata("Data not found for update", "400");
                status = HttpStatus.NOT_FOUND;
            }
        } catch (Exception e){
            response.setMetadata(e.getMessage(), "500");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<UsuarioResponseRest>(response, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioResponseRest> deleteUsuarios(@PathVariable Long id) {
        UsuarioResponseRest response = new UsuarioResponseRest();
        HttpStatus status;
        try{
            UsuarioDTO usuarioDTO = this.services.delete(id);
            response.getUsuariosResponse().setUsuarios(usuarioDTO);
            response.setMetadata("success");
            status = HttpStatus.OK;
        } catch (Exception e){
            response.setMetadata(e.getMessage(), "500");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<UsuarioResponseRest>(response, status);
    }
}
