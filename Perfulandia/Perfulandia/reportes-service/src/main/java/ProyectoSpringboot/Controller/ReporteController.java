package ProyectoSpringboot.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProyectoSpringboot.Service.ReporteService;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/ventas/total")
    public Double obtenerTotalVentas() {
        return reporteService.obtenerTotalVentas();
    }

    @GetMapping("/ventas/por-dia")
    public Map<String, Double> obtenerVentasPorDia() {
        return reporteService.obtenerVentasPorDia();
    }
}
