package com.example.productservice.controlers;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

     private CategoryService categoryService;
     public CategoryController(CategoryService categoryService)
     {
         this.categoryService=categoryService;
     }
    @GetMapping()
    public List<Category> getAllCategories()
    {
        //ResponseEntity<Category> responseEntity=new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryName}")
    public List<Product> getProductsInCategory(@PathVariable("categoryName") String categoryName)
    {

        return categoryService.getProductsInCategory(categoryName);
    }

}
