package com.elrond.controller;

import com.elrond.entity.Parametro;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ParametroController {

    @RequestMapping("/api/parametro")
    public List<Parametro> buscarParametro() {
        List<Parametro> parametros = new ArrayList<Parametro>();
        parametros.add(new Parametro(1, "urlLdap", "valorLdap"));
        parametros.add(new Parametro(2, "urlLdap2", "valorLdap2"));
        parametros.add(new Parametro(3, "urlLdap3", "valorLdap3"));
        return parametros;
    }
}
