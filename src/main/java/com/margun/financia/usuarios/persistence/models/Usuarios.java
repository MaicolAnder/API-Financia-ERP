package com.margun.financia.usuarios.persistence.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = -4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;

    private String usuario;
    private String contrasena;
    private String clave;
    private String llave_pago;

    @Nullable
    private String fecha_creacion;

    @Nullable
    private Date fecha_modificacion;

    @Nullable
    @Column(name = "fecha_ultimoAcceso")
    private Date fecha_ultimoAcceso;
}