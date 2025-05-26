package ProyectoSpringboot.Service;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Value;

@Service
public class ReporteService {
    private final RestTemplate restTemplate;
    
    @Value("${servicio.ventas.url}")
    private String ventasUrl;

    public ReporteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Double obtenerTotalVentas() {
        // Lógica para obtener el total de ventas
        return restTemplate.getForObject(ventasUrl + "/api/ventas/total", Double.class);
    }

    public Map<String, Double> obtenerVentasPorDia() {
        ResponseEntity<Map<String, Double>> response = restTemplate.exchange(
            ventasUrl + "/api/ventas/por-dia",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Map<String, Double>>() {}
        );
        return response.getBody();
    }
}
