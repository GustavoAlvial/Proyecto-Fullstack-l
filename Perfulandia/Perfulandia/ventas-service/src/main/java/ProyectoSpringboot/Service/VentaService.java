package ProyectoSpringboot.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ProyectoSpringboot.Model.DetalleVenta;
import ProyectoSpringboot.Model.Venta;
import ProyectoSpringboot.Repository.DetalleVentaRepository;
import ProyectoSpringboot.Repository.VentaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentaService {
    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;

    public Venta crearVentaConDetalles(Venta venta) {
        venta.setFecha(LocalDateTime.now());
        
        double totalVenta = 0.0;
        if (venta.getDetalles() != null) {
            for (DetalleVenta detalle : venta.getDetalles()) {
                detalle.setVenta(venta);
                totalVenta += detalle.getPrecioUnitario() * detalle.getCantidad();
            }
        }
        venta.setTotal(totalVenta);

        return ventaRepository.save(venta);
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> buscarVentaPorId(Long id) {
        return ventaRepository.findById(id);
    }

    public List<Object[]> obtenerProductosMasVendidos() {
        return detalleVentaRepository.findProductosMasVendidos();
    }

    public Double calcularTotalVentas() {
        return (double) ventaRepository.count();
    }
}
