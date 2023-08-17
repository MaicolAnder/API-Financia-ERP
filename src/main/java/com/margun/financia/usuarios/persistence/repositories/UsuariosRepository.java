package com.margun.financia.usuarios.persistence.repositories;

import com.margun.financia.usuarios.persistence.models.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<Usuarios, Long> { }
