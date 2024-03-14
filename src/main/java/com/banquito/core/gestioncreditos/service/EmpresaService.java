package com.banquito.core.gestioncreditos.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.core.gestioncreditos.service.ExternalService.EmpresaRestService;

@Service
public class EmpresaService {

        private final EmpresaRestService empresasRestService;


    public EmpresaService(EmpresaRestService empresasRestService) {
        this.empresasRestService = empresasRestService;
    }

    public ResponseEntity<String> listarEmpresas(){
        return this.empresasRestService.listarEmpresas();
    }

    public ResponseEntity<String> obtenerPorTipoIndentificacion(String numero){
        return this.empresasRestService.obtenerPorIdentificacion(numero);
    }
}