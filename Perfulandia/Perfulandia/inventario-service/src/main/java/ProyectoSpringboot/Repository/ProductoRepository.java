package ProyectoSpringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoSpringboot.Model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
