package pe.cibertec.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String clave;

}
