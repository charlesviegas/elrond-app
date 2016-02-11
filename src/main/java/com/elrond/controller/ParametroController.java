package com.elrond.controller;

import com.elrond.entity.Parametro;
import com.elrond.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasAuthority('ADMINISTRADOR')")
@RequestMapping(value = "/api/parametro")
public class ParametroController {

    @Autowired
    ParametroRepository parametroRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Parametro> buscarParametro() {
        return parametroRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Parametro gravarParametro(@Validated @RequestBody Parametro parametro) {
        return parametroRepository.save(parametro);
    }

    @RequestMapping(value = "/api/parametro/{id}", method = RequestMethod.DELETE)
    public void excluir(@PathVariable("id") Long id) {
        parametroRepository.delete(id);
    }

}