package com.banquito.core.gestioncreditos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.gestioncreditos.service.CreditoService;
import com.banquito.core.gestioncreditos.service.TipoCreditoService;

@RestController
@RequestMapping("/api/v1/creditos")
public class CreditoController {
    
    private final ClienteNaturalService clienteNaturalService;
    private final EmpresaService empresaService;


    public ClienteController(ClienteNaturalService clienteNaturalService, EmpresaService empresaService) {
        this.clienteNaturalService = clienteNaturalService;
        this.empresaService = empresaService;
    }
}