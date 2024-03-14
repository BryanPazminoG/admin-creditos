package com.banquito.core.gestioncreditos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.gestioncreditos.service.CuentaService;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaController {
    
    private final CuentaService cuentaService;


    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/cuentas")
    public ResponseEntity<String> listarCuentas() {
        return cuentaService.listarTodo();
    }

    @GetMapping("/cuentas/{codCuenta}")
    public ResponseEntity<String> obtenerCuentaPorId(@PathVariable Integer codCuenta) {
        return cuentaService.obtenerPorId(codCuenta);
    }

    @PostMapping("/cuentas")
    public ResponseEntity<String> crearCuenta(@RequestBody String informacionCuenta) {
        return cuentaService.crear(informacionCuenta);
    }

    @PutMapping("/cuentas/{codCuenta}")
    public ResponseEntity<String> actualizarCuenta(@PathVariable Integer codCuenta, @RequestBody String informacionCuenta) {
        return cuentaService.actualizar(codCuenta, informacionCuenta);
    }

    @DeleteMapping("/cuentas/{idCuenta}")
    public ResponseEntity<String> eliminarCuenta(@PathVariable Integer idCuenta) {
        return cuentaService.eliminar(idCuenta);
    }

    @GetMapping("/cuentas/numero/{numeroCuenta}")
    public ResponseEntity<String> obtenerCuentaPorNumeroCuenta(@PathVariable String numeroCuenta) {
        return cuentaService.obtenerPorNumeroCuenta(numeroCuenta);
    }

    @PutMapping("/cuentas/actualizarBalance")
    public ResponseEntity<String> actualizarBalance(@RequestParam String informacionCuenta, @RequestParam String codCuenta) {
        return cuentaService.actualizarBalance(informacionCuenta, codCuenta);
    }

    @GetMapping("/cuentas/cliente/{codCliente}")
    public ResponseEntity<String> obtenerCuentasPorCliente(@PathVariable String codCliente) {
        return cuentaService.obtenerCuentasCliente(codCliente);
    }
}
