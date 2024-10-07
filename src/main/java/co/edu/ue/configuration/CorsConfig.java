package co.edu.ue.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/") // Ajusta la ruta si es necesario
                .allowedOrigins("http://127.0.0.1:5501") // Permitir el origen específico
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("") // Permitir cualquier encabezado
                .allowCredentials(true); // Permitir envío de cookies o autenticación
    }
}
