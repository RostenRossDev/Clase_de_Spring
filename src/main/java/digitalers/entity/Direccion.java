package digitalers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "DIRECCIONES")
public class Direccion {

    @Id
    @Column(name = "DIRECCION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String barrio;
    private String altura;

    @JsonIgnore
    @OneToMany(mappedBy = "direccion")
    List<Persona> personas;
}
