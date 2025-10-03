package digitalers.service.impl;

import digitalers.dto.PersonaDto;
import digitalers.entity.Direccion;
import digitalers.entity.Persona;
import digitalers.repository.DireccionRepository;
import digitalers.repository.PersonaRepository;
import digitalers.service.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicioDePersona")
public class PersonaServiceImpl implements PersonaServicio {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    DireccionRepository direccionRepository;

    @Override
    public ResponseEntity<?> todasLasPersonas() {
        try{
            List<Persona> personas = personaRepository.findAll();
            if (!personas.isEmpty()){
                return ResponseEntity.ok().body(personas);
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Ocurrio un error interno");
        }
    }

    @Override
    public Persona personaPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona crearPersonas(PersonaDto p) {
        Persona newPersona = new Persona();
        newPersona.setEdad(p.edad());
        newPersona.setNombre(p.nombre());
        newPersona.setEmail(p.email());
        newPersona.setTelefono(p.telefono());
        Direccion direccion = direccionRepository.findById(p.direccionId()).orElse(null);
        newPersona.setDireccion(direccion);

        return personaRepository.save(newPersona);
    }

    @Override
    public void eliminarPorId(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona actualizarPersona(PersonaDto p, Long id) {
        Persona updatedPersona = new Persona();
        updatedPersona.setId(id);
        updatedPersona.setEdad(p.edad());
        updatedPersona.setNombre(p.nombre());
        updatedPersona.setEmail(p.email());
        updatedPersona.setTelefono(p.telefono());
        Direccion direccion = direccionRepository.findById(p.direccionId()).orElse(null);
        updatedPersona.setDireccion(direccion);
        return personaRepository.save(updatedPersona);
    }
}
