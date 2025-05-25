package ProyectoSpringboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ProyectoSpringboot.Model.Producto;
import ProyectoSpringboot.Repository.ProductoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;
    
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto updateProducto(Long id, Producto producto) {
        Optional<Producto> existingProducto = productoRepository.findById(id);

        if (existingProducto.isPresent()) {
            Producto updatedProducto = existingProducto.get();
            updatedProducto.setNombre(producto.getNombre());
            updatedProducto.setDescripcion(producto.getDescripcion());
            updatedProducto.setPrecio(producto.getPrecio());
            updatedProducto.setStock(producto.getStock());
            return productoRepository.save(updatedProducto);
        }
        return null;
    }

    public void deleteProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        }
    }

}
