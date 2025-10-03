package digitalers.dto;

import lombok.Data;

public record  PersonaDto (String nombre, Integer edad, Long direccionId, String telefono, String email) {}

