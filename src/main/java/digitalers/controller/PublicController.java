package digitalers.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PublicController", description = "Controlador para todos los recursos publicos")
@RequestMapping("/public")
@RestController
public class PublicController {

    //@Tag(name = "saludar()", description = "Metodo de prueba de nuestros primer controlador")
    @GetMapping("/prueba")
    public ResponseEntity<?> saludar(){
        return ResponseEntity.ok("Hola desde un recurso publico");
    }
}
