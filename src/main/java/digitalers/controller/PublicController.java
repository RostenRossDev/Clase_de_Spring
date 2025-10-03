package digitalers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/public")
@RestController
public class PublicController {

    @GetMapping("/prueba")
    public ResponseEntity<?> saludar(){
        return ResponseEntity.ok("Hola desde un recurso publico");
    }
}
