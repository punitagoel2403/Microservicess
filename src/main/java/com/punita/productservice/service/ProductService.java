package com.punita.productservice.service;

import com.punita.productservice.dto.ProductRequest;
import com.punita.productservice.dto.ProductResponse;
import com.punita.productservice.model.Product;
import com.punita.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .createdOn(new Date())
                .build();

        productRepository.save(product);

    }

    public List<ProductResponse> getAllProducts() {
       List<Product> products=  productRepository.findAll();

       return products.stream().map(this::mapToProductResponse).toList();
    }



    public ProductResponse getProductById(String productId) {
        Optional<Product> product =  productRepository.findById(productId);
        return product.map(this::mapToProductResponse).orElse(null);
    }


    private ProductResponse mapToProductResponse(Product product) {

        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
