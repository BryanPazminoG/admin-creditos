package com.banquito.core.gestioncreditos.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.core.gestioncreditos.service.ExternalService.CreditoRestService;

@Service
public class CreditoService {

    private CreditoRestService creditoRestService;

    public CreditoService(CreditoRestService creditoRestService) {
        this.creditoRestService = creditoRestService;
    }

    public ResponseEntity<String> obtenerPorId(Integer id) {
        return creditoRestService.obtenerPorId(id);
    }

    public ResponseEntity<String> crear(String creditoInfo) {
        return creditoRestService.crear(creditoInfo);
    }

    public ResponseEntity<String> buscarPorCliente(String codCliente) {
        return creditoRestService.buscarPorCliente(codCliente);
    }

    public ResponseEntity<String> actualizar(String creditoInfo, Integer id) {
        return creditoRestService.actualizar(creditoInfo, id);
    }

    public ResponseEntity<String> cambiarEstado(String codCredito, String estado) {
        return creditoRestService.cambiarEstado(null, estado);
    }
}
