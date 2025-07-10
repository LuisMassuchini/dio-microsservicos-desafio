package br.com.dio.challenge.ordersimulator;

import br.com.dio.challenge.ordersimulator.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-catalog")
public interface ProductClient {

    @GetMapping("/produtos/{id}")
    ProductDTO findById(@PathVariable("id") Long id);
}
