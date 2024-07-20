package com.punita.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String productId;
    private String name;
    private String description;
    private Float price;
    private Date createdOn;


}
