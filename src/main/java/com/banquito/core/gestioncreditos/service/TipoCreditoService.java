package com.banquito.core.gestioncreditos.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.core.gestioncreditos.service.ExternalService.TipoCreditoRestService;

@Service
public class TipoCreditoService {

    private final TipoCreditoRestService tipoCreditoRestService;

    public TipoCreditoService(TipoCreditoRestService tipoCreditoRestService) {
        this.tipoCreditoRestService = tipoCreditoRestService;
    }

    public ResponseEntity<String> obtenerPorId(Integer id) {
        return tipoCreditoRestService.obtenerPorId(id);
    }

    public ResponseEntity<String> listar() {
        return tipoCreditoRestService.listar();
    }

    public ResponseEntity<String> listarActivos() {
        return tipoCreditoRestService.listarActivos();
    }

    public ResponseEntity<String> crear(String informacionTipoCredito) {
        return tipoCreditoRestService.crear(informacionTipoCredito);
    }

    public ResponseEntity<String> actualizar(Integer id,String informacionTipoCredito) {
        return tipoCreditoRestService.actualizar(id,informacionTipoCredito);
    }

    public ResponseEntity<String> cambiarEstado(Integer codTipoCredito, String estado) {
        return tipoCreditoRestService.cambiarEstado(codTipoCredito, estado);
    }
}
