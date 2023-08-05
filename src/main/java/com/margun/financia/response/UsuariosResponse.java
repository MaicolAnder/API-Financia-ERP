package com.margun.financia.response;

import com.margun.financia.model.Usuarios;
import lombok.Data;

import java.util.List;

@Data
public class UsuariosResponse {
    private List<Usuarios> usuarios;

}
