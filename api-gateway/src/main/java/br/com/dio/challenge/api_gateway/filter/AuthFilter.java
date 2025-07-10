package br.com.dio.challenge.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.List;

@Component
public class AuthFilter implements GlobalFilter, Ordered {

    // Nosso token secreto. Em um sistema real, isso viria de um lugar seguro.
    private static final String SECRET_TOKEN = "dio-desafio-token-secreto-123";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Pega os cabeçalhos da requisição
        List<String> authHeaders = exchange.getRequest().getHeaders().get("Authorization");

        // 1. Verifica se o cabeçalho 'Authorization' existe
        if (authHeaders == null || authHeaders.isEmpty()) {
            return sendError(exchange, HttpStatus.UNAUTHORIZED);
        }

        String authHeader = authHeaders.get(0);

        // 2. Verifica se o cabeçalho começa com "Bearer "
        if (!authHeader.startsWith("Bearer ")) {
            return sendError(exchange, HttpStatus.UNAUTHORIZED);
        }

        // 3. Extrai o token e compara com o nosso token secreto
        String token = authHeader.substring(7);
        if (!SECRET_TOKEN.equals(token)) {
            return sendError(exchange, HttpStatus.UNAUTHORIZED);
        }

        // Se tudo estiver OK, deixa a requisição continuar
        return chain.filter(exchange);
    }

    // Método auxiliar para retornar uma resposta de erro
    private Mono<Void> sendError(ServerWebExchange exchange, HttpStatus status) {
        exchange.getResponse().setStatusCode(status);
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -1; // Define a ordem de execução do filtro. -1 significa alta prioridade.
    }
}