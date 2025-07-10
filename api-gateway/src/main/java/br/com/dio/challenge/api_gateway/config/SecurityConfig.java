package br.com.dio.challenge.api_gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita a proteção CSRF (não necessária para APIs stateless)
                .authorizeExchange(auth -> auth
                        .anyExchange().permitAll() // Permite todas as requisições por padrão, pois nosso filtro fará a segurança
                );
        return http.build();

    }
}
