package com.elrond.controller;

import com.elrond.entity.Parametro;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/parametro")
public class ParametroController {

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @RequestMapping(method = RequestMethod.GET)
    public List<Parametro> buscarParametro() {
        List<Parametro> parametros = new ArrayList<Parametro>();
        parametros.add(new Parametro(1, "urlLdap", "valorLdap"));
        parametros.add(new Parametro(2, "urlLdap2", "valorLdap2"));
        parametros.add(new Parametro(3, "urlLdap3", "valorLdap3"));
        return parametros;
    }
}
