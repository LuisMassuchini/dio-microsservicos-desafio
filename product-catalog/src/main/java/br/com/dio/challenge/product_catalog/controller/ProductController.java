package br.com.dio.challenge.product_catalog.controller;

import br.com.dio.challenge.product_catalog.model.Product;
import br.com.dio.challenge.product_catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return  productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }
}
