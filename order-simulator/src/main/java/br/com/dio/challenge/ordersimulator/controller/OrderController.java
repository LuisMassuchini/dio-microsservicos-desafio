// src/main/java/br/com/dio/challenge/ordersimulator/controller/OrderController.java
package br.com.dio.challenge.ordersimulator.controller;


import br.com.dio.challenge.ordersimulator.ProductClient;
import br.com.dio.challenge.ordersimulator.dto.OrderRequest;
import br.com.dio.challenge.ordersimulator.dto.OrderResponse;
import br.com.dio.challenge.ordersimulator.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/pedidos")
public class OrderController {

    // Injetamos nosso cliente Feign. O Spring nos fornecerá a implementação.
    @Autowired
    private ProductClient productClient;

    @PostMapping
    public OrderResponse simulateOrder(@RequestBody OrderRequest orderRequest) {
        // 1. Para cada ID na requisição, usamos o ProductClient para buscar o produto no outro serviço.
        List<ProductDTO> fetchedProducts = orderRequest.getProductIds().stream()
                .map(productClient::findById) // Chama o método findById para cada ID.
                .filter(Objects::nonNull) // Filtra produtos que não foram encontrados (retornaram nulo).
                .collect(Collectors.toList());

        // 2. Com a lista de produtos em mãos, calculamos o preço total.
        double totalPrice = fetchedProducts.stream()
                .mapToDouble(ProductDTO::getPrice) // Pega o preço de cada produto.
                .sum(); // Soma todos os preços.

        // 3. Criamos e retornamos nossa resposta.
        return new OrderResponse(fetchedProducts, totalPrice);
    }
}