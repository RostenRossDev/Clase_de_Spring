package digitalers.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "PERSONAS")
public class Persona {

    @Id
    @Column(name = "PERSONA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "DIRECCION_ID", nullable = false)
    private Direccion direccion;

    @Column(unique = true)
    private String telefono;

    @Column(unique = true)
    private String email;
}
