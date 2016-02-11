package com.elrond.repository;

import com.elrond.entity.Parametro;
import com.elrond.entity.UsuarioPerfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioPerfilRepository extends CrudRepository<UsuarioPerfil, Long> {

}
