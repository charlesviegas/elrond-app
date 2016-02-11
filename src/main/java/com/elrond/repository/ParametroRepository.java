package com.elrond.repository;

import com.elrond.entity.Parametro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepository  extends CrudRepository<Parametro, Long> {

}
