package ProyectoSpringboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ProyectoSpringboot.Model.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    @Query( "SELECT d.productoId, SUM(d.cantidad) AS totalVendidos" +
            "FROM DetalleVenta dv GROUP BY d.productoId ORDER BY totalVendidos DESC")
    List<Object[]> findProductosMasVendidos();

}
