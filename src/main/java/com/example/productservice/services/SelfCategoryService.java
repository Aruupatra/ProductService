package com.example.productservice.services;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepositories;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class SelfCategoryService implements CategoryService{

    private CategoryRepositories categoryRepositories;
    public SelfCategoryService(CategoryRepositories categoryRepositories)
    {
        this.categoryRepositories=categoryRepositories;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepositories.findAll();
    }

    @Override
    public List<Product> getProductsInCategory(String name) {
        return categoryRepositories.findProductByCategoryName(name);
    }
}
