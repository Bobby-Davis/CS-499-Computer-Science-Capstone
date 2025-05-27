package com.animals.rescue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Inject custom JWT filter that checks for a valid token on every request
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final CorsConfigurationSource corsConfigurationSource;

    // Constructor injection for JwtAuthenticationFilter
    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,CorsConfigurationSource corsConfigurationSource) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.corsConfigurationSource = corsConfigurationSource;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println(">>> SecurityConfig initialized"); // debug check

        http
             // disable CSRF (not needed for stateless REST APIs using tokens)
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource))


            // Define authorization rules: 
            .authorizeHttpRequests(auth -> auth
                // Allow these endpoints without being logged in
                .requestMatchers("/login", "/register").permitAll()

                // Allow unauthenticated GET (public access)
                .requestMatchers(HttpMethod.GET, "/api/animals").permitAll()

                // Allow authenticated POST, PUT, DELETE to /api/animals
                .requestMatchers(HttpMethod.POST, "/api/animals").authenticated()
                .requestMatchers(HttpMethod.PUT, "/api/animals/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/api/animals/**").authenticated()
                // Require authentication for everything else
                .anyRequest().authenticated()
            )

            // disable default login process
            .formLogin(form -> form.disable())
            .httpBasic(httpBasic -> httpBasic.disable())
            
            // Add the JWT filter before Spring's UsernamePasswordAuthenticationFilter
            // This makes sure we extract the token and authenticate before other filters run
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // Returns full security chain
        return http.build();
    }

    // Spring needs an AuthenticationManager to handle login logic
    // This bean gives access to that manager using the default configuration

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}