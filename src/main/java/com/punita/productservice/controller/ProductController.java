package com.punita.productservice.controller;


import com.punita.productservice.dto.ProductRequest;
import com.punita.productservice.dto.ProductResponse;
import com.punita.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {

        productService.createProduct(productRequest);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String productId) {
        return Optional.ofNullable(productService.getProductById(productId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());

    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return Optional.ofNullable(productService.getAllProducts())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

}
