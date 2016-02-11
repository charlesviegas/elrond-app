package com.elrond.repository;

import com.elrond.entity.Parametro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParametroRepository extends CrudRepository<Parametro, Long> {

    @Query("SELECT p FROM Parametro p WHERE p.nome like ?1% OR p.valor like ?1% OR p.descricao like ?1%")
    List<Parametro> buscarParametroPorFiltro(String texto);
}
