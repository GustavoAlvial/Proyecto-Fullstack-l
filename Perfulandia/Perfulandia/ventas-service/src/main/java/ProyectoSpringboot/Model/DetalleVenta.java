package ProyectoSpringboot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {
    @Id@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long productoId;
    private int cantidad;
    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
}
