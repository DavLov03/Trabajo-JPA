package org.example;


import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "Persona")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    // Constructor, getters y setters

}
