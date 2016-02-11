package com.elrond.controller;

import com.elrond.entity.Parametro;
import com.elrond.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/parametro")
public class ParametroController {

    @Autowired
    private ParametroRepository parametroRepository;

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Parametro> buscarParametro() {
        return parametroRepository.findAll();
    }
}
