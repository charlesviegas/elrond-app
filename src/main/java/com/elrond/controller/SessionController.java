package com.elrond.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/session")
public class SessionController {

    @RequestMapping(method = RequestMethod.GET)
    public Object getSessaoAtual() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
