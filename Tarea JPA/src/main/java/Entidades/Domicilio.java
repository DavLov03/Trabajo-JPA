package Entidades;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "Domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombreCalle")
    private String nombreCalle;
    @Column(name = "numero")
    private int numero;
    //@OneToOne(mappedby="domicilio")
    //private Cliente cliente;
}
