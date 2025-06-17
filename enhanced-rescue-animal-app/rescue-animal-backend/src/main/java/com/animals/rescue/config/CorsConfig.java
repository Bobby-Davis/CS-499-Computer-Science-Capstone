package com.animals.rescue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();
        
        // Allow request from server
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));

        // Allow all HTTP methods: GET, POST, PUT, DELETE
        config.setAllowedMethods(Arrays.asList("*"));

        // Allow all headers 
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowCredentials(true); 

        // Register this configuration for all the paths in this application 
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
