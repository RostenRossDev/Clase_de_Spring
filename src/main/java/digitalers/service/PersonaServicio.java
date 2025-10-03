package digitalers.service;

import digitalers.dto.PersonaDto;
import digitalers.entity.Persona;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaServicio {

    ResponseEntity<?> todasLasPersonas();

    Persona personaPorId(Long id);

    Persona crearPersonas(PersonaDto p);

    void eliminarPorId(Long id);

    Persona actualizarPersona(PersonaDto p, Long d);
}
