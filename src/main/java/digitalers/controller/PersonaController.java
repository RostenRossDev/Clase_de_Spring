package digitalers.controller;

import digitalers.dto.PersonaDto;
import digitalers.entity.Persona;
import digitalers.service.PersonaServicio;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Personas", description = "CRUD completo de personas")
@RequestMapping("/personas")
@RestController
public class PersonaController {

    @Qualifier("servicioDePersona")
    @Autowired
    PersonaServicio personaServicio;


    @GetMapping
    public ResponseEntity<?> getPersonas(){
        return personaServicio.todasLasPersonas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersona(@PathVariable(name = "id") Long personaId){
        return ResponseEntity.ok().body(personaServicio.personaPorId(personaId));
    }

    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody PersonaDto dto){
        return ResponseEntity.ok().body(personaServicio.crearPersonas(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizar(@RequestBody PersonaDto dto, @PathVariable(name = "id") Long idPersona){
        return ResponseEntity.ok().body(personaServicio.actualizarPersona(dto, idPersona));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable(name = "id") Long idPersona){
        personaServicio.eliminarPorId(idPersona);
        return ResponseEntity.ok().body("Persona con id " + idPersona + " eliminada con exito.");
    }
}
