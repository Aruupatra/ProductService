package com.example.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Category extends Basemodel{


    private String name;
    private String description;
    private List<Product> products;
}
