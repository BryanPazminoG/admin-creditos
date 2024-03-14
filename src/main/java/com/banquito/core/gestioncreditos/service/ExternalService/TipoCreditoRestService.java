package com.banquito.core.gestioncreditos.service.ExternalService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TipoCreditoRestService {

    private final RestTemplate restTemplate;

    public TipoCreditoRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> obtenerPorId(Integer id) {
        String url = "http://localhost:8081/api/v1/tiposcredito/" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> listar() {
        String url = "http://localhost:8081/api/v1/tiposcredito";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> listarActivos() {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/tiposcredito")
                .queryParam("estado", "ACT")
                .build()
                .toString();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> crear(String tipoCreditoDtoJson) {
        String url = "http://localhost:8081/api/v1/tiposcredito";
        ResponseEntity<String> response = restTemplate.postForEntity(url, tipoCreditoDtoJson, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> actualizar(Integer id, String tipoCreditoDtoJson) {
        String url = "http://localhost:8081/api/v1/tiposcredito/" + id;
        restTemplate.put(url, tipoCreditoDtoJson);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<String> cambiarEstado(Integer id, String estado) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/tiposcredito")
                .pathSegment(id.toString(), "estado")
                .queryParam("estado", estado)
                .build()
                .toString();
        restTemplate.put(url, null);
        return ResponseEntity.noContent().build();
    }

    private void validarRespuesta(ResponseEntity<String> response) {
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Error al obtener la información desde el servicio externo");
        }
    }
}
