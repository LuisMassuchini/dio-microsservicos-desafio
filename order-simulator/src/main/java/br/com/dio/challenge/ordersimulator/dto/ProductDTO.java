package br.com.dio.challenge.ordersimulator.dto;

// Removemos as anotações @Getter e @Setter
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private double price;

    // --- MÉTODOS GETTERS ---
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Este é o método que precisamos e que o @Getter deveria ter criado.
    public double getPrice() {
        return price;
    }

    // --- MÉTODOS SETTERS ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}