package ProyectoSpringboot.Perfulandia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoSpringboot.Perfulandia.Model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
