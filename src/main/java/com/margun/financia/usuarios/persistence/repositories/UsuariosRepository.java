package com.margun.financia.usuarios.persistence.repositories;

import com.margun.financia.usuarios.persistence.models.Usuarios;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO Interface for Usuarios Model and extends Spring CrudRepository
 * @author Miguel A Tunubalá
 */
public interface UsuariosRepository extends CrudRepository<Usuarios, Long> { }
