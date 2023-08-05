package com.margun.financia.dao;

import com.margun.financia.model.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosInterface extends CrudRepository<Usuarios, Long> {

}
