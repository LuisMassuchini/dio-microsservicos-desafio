package br.com.dio.challenge.ordersimulator.dto;

import java.util.List;

// Removemos TODAS as anotações do Lombok (@Getter, @Setter, @AllArgsConstructor)
public class OrderResponse {

    private List<ProductDTO> products;
    private double totalPrice;

    // Este é o construtor que o @AllArgsConstructor deveria ter criado.
    // Agora o estamos escrevendo manualmente.
    public OrderResponse(List<ProductDTO> products, double totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
    }

    // Já que estamos aqui, vamos adicionar os getters manualmente também.
    public List<ProductDTO> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // E os setters.
    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}