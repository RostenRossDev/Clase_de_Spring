package digitalers.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Digitalers API Documentation")
                        .version("1.1")
                        .description("API documentation for the Digitalers project"))
                .servers(List.of(new Server().url("http://localhost:8080")))
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()));
    }

    /**
     * Crea el esquema de seguridad para JWT.
     * Configura Swagger para aceptar tokens Bearer en el header Authorization.
     *
     * @return SecurityScheme configurado para JWT
     */
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)     // Tipo HTTP
                .bearerFormat("JWT")                 // Formato del token: JWT
                .scheme("bearer");                   // Esquema: Bearer
    }
}
