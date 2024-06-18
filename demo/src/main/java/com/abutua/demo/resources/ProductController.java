package com.abutua.demo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.demo.models.Product;

import jakarta.annotation.PostConstruct;

@RestController
public class ProductController {

    private List<Product> products = Arrays.asList(
        new Product(1, "Product 01","Description 01", 1, false, false, 100.50),
        new Product(2, "Product 02","Description 02", 2, true, false, 200.50),
       new Product(3, "Product 03","Description 03", 3, false, true, 300.50)
       );


    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
    

        Product prod = products.stream()
                               .filter( p -> p.getId() == id).findFirst()
                               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found"));

        return ResponseEntity.ok(prod);
    }

    @GetMapping("products")
    public List<Product> GetProducts(){
        return products;

    }
    
}
