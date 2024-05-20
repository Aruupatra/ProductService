package com.example.productservice.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class Product extends Basemodel {

    private String title;
    private double price;
    private String description;
    private Category category;
    private String image;
}
