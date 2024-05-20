package com.example.productservice.services;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {


    public List<Category> getAllCategories();
    public List<Product> getProductsInCategory(String name);
}
