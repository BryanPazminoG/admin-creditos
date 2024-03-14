package com.banquito.core.gestioncreditos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.gestioncreditos.service.CreditoService;
import com.banquito.core.gestioncreditos.service.TipoCreditoService;

@RestController
@RequestMapping("/api/v1/creditos")
public class CreditoController {
    
    private final CreditoService creditoService;
    private final TipoCreditoService tipoCreditoService;


    public CreditoController(CreditoService creditoService, TipoCreditoService tipoCreditoService) {
        this.creditoService = creditoService;
        this.tipoCreditoService = tipoCreditoService;
    }

    @GetMapping("/creditos/{id}")
    public ResponseEntity<String> obtenerCreditoPorId(@PathVariable Integer id) {
        return creditoService.obtenerPorId(id);
    }

    @PostMapping("/creditos")
    public ResponseEntity<String> crearCredito(@RequestBody String creditoInfo) {
        return creditoService.crear(creditoInfo);
    }

    @GetMapping("/creditos/cliente/{codCliente}")
    public ResponseEntity<String> buscarCreditosPorCliente(@PathVariable String codCliente) {
        return creditoService.buscarPorCliente(codCliente);
    }

    @PutMapping("/creditos/{id}")
    public ResponseEntity<String> actualizarCredito(@PathVariable Integer id, @RequestBody String creditoInfo) {
        return creditoService.actualizar(creditoInfo, id);
    }

    @PatchMapping("/creditos/cambiarEstado")
    public ResponseEntity<String> cambiarEstadoCredito(@RequestParam String codCredito, @RequestParam String estado) {
        return creditoService.cambiarEstado(codCredito, estado);
    }

    @GetMapping("/tipos-credito/{id}")
    public ResponseEntity<String> obtenerTipoCreditoPorId(@PathVariable Integer id) {
        return tipoCreditoService.obtenerPorId(id);
    }

    @GetMapping("/tipos-credito")
    public ResponseEntity<String> listarTiposCredito() {
        return tipoCreditoService.listar();
    }

    @GetMapping("/tipos-credito/activos")
    public ResponseEntity<String> listarTiposCreditoActivos() {
        return tipoCreditoService.listarActivos();
    }

    @PostMapping("/tipos-credito")
    public ResponseEntity<String> crearTipoCredito(@RequestBody String informacionTipoCredito) {
        return tipoCreditoService.crear(informacionTipoCredito);
    }

    @PutMapping("/tipos-credito/{id}")
    public ResponseEntity<String> actualizarTipoCredito(@PathVariable Integer id, @RequestBody String informacionTipoCredito) {
        return tipoCreditoService.actualizar(id, informacionTipoCredito);
    }

    @PatchMapping("/tipos-credito/cambiarEstado")
    public ResponseEntity<String> cambiarEstadoTipoCredito(@RequestParam Integer codTipoCredito, @RequestParam String estado) {
        return tipoCreditoService.cambiarEstado(codTipoCredito, estado);
    }
}
