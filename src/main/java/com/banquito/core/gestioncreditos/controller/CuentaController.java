package com.banquito.core.gestioncreditos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.gestioncreditos.service.CuentaService;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaController {
    
    private final CuentaService cuentaService;


    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }
}