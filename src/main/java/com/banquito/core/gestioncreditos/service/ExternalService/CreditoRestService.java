package com.banquito.core.gestioncreditos.service.ExternalService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CreditoRestService {

    private final RestTemplate restTemplate;

    public CreditoRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> obtenerPorId(Integer id) {
        String url = "http://localhost:8081/api/v1/creditos/" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> crear(String creditoDtoJson) {
        String url = "http://localhost:8081/api/v1/creditos";
        ResponseEntity<String> response = restTemplate.postForEntity(url, creditoDtoJson, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> buscarPorCliente(String codCliente) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/creditos")
                .queryParam("codCliente", codCliente)
                .build()
                .toString();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> actualizar(String creditoDtoJson, Integer id) {
        String url = "http://localhost:8081/api/v1/creditos/" + id;
        restTemplate.put(url, creditoDtoJson);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<String> cambiarEstado(Integer id, String estado) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/creditos")
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
