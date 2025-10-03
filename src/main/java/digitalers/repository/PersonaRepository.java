package digitalers.repository;

import digitalers.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {


//    List<Persona> findDistinctByNombreAndEdad(String nombre, int edad);
//
//    List<Persona> findByEmailAndNombre(String email, String nombre);

    //             Select * from personas
//    @Query(name = "select p from Persona p where p.direccion.calle != :calle")
//    List<Persona> buscarPersonasQueVivanEnCalle(@Param("calle") String street);
}
