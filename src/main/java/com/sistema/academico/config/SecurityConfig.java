package com.sistema.academico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User; // Novo
import org.springframework.security.core.userdetails.UserDetails; // Novo
import org.springframework.security.core.userdetails.UserDetailsService; // Novo
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Novo
import org.springframework.security.crypto.password.PasswordEncoder; // Novo
import org.springframework.security.provisioning.InMemoryUserDetailsManager; // Novo
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(withDefaults()) // HABILITA O CORS
            .authorizeHttpRequests(auth -> auth
                // LIBERA: Swagger, Banco H2 e Métricas (Actuator)
                .requestMatchers("/h2-console/**", "/swagger-ui/**", "/v3/api-docs/**", "/actuator/**").permitAll()
                // PROTEGE: Todo o resto precisa de login (incluindo /cursos)
                .anyRequest().authenticated()
            )
            .headers(h -> h.frameOptions(f -> f.disable()))
            .httpBasic(withDefaults());
        return http.build();
    }

    // --- NOVO: Configuração do Usuário para Testes ---

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Define o encoder de senhas (BCrypt é o padrão)
        // O Spring Security exige este Bean, mesmo que usemos {noop} abaixo.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Define o usuário 'admin' na memória
        UserDetails admin = User.builder()
            .username("admin")
            // IMPORTANTE: {noop} faz o Spring reconhecer a senha "123" sem criptografar.
            // Para produção, você usaria .password(passwordEncoder().encode("123"))
            .password("{noop}123") 
            .roles("ADMIN", "USER")
            .build();
        return new InMemoryUserDetailsManager(admin);
    }

    // --- FIM NOVO: Configuração do Usuário ---

    // Configuração Explícita do CORS para a porta 5173
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Apenas a porta do React é permitida
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173")); 
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}