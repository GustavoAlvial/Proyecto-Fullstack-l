package ProyectoSpringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoSpringboot.Model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar ventas por fecha, cliente, etc.

}
