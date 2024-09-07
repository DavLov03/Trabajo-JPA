package Entidades;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "DetalleFactura")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class DetalleFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "id")
    private Long id;
    @Column(name = "subtotal")
    private int subtotal;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;
}
