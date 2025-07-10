package br.com.dio.challenge.ordersimulator.dto;

import java.util.List;

// Removemos as anotações @Getter e @Setter
public class OrderRequest {

    private List<Long> productIds;

    // Este é o método que o @Getter deveria ter criado para nós.
    // Agora ele existe de verdade no nosso código.
    public List<Long> getProductIds() {
        return this.productIds;
    }

    // Este é o método que o @Setter criaria.
    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}