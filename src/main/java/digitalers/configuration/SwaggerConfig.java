package digitalers.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

import io.swagger.v3.oas.models.tags.Tag;
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
                        .version("1.1.0")
                        .description("API REST completa para el proyecto Digitalers. " +
                                "Incluye gestión de personas, autenticación JWT y más.")

                        // Información de contacto
                        .contact(new Contact()
                                .name("Equipo Digitalers")
                                .email("soporte@digitalers.com")
                                .url("https://www.digitalers.com"))

                        // Licencia
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))

                        // Términos de servicio
                        .termsOfService("https://www.digitalers.com/terms"))
                //URL del servidor
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Desarrollo"),
                        new Server().url("https://api.digitalers.com").description("Producción")
                ))
                //configuracion de seguridad
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
                // Documentación externa
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación completa en Confluence")
                        .url("https://es.wikipedia.org/wiki/Wiki"));
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
