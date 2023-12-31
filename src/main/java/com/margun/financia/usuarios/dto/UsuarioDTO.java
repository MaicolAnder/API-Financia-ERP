package com.margun.financia.usuarios.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

/**
 * Data transfer Object Serializable for Usuarios
 * @author Miguel A Tunubalá
 */
@Setter
@Getter
public class UsuarioDTO implements Serializable {
    private long id_usuario;
    private String usuario;
    private String contrasena;
    private String clave;
    private String llave_pago;
    private Date fecha_modificacion;
    private Date fecha_ultimoAcceso;
}
