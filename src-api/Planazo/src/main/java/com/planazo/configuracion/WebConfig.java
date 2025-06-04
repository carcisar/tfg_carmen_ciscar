package com.planazo.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // CORS para Angular (tanto en dev como en prod)
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // aplica a todas las rutas
                // permite localhost:4200 (desarrollo) y planazo-front.onrender.com (producción)
                .allowedOrigins(
                    "http://localhost:4200",
                    "https://planazo-front.onrender.com"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
    
    // Configuración para servir archivos estáticos (no cambia)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:C:/Users/carme/OneDrive/Escritorio/PROYECTO/PFG_CarmenCiscar/docs/assets/actividades/");
    }
}