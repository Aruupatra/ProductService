package com.example.productservice.services;

import com.example.productservice.dtos.ProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepositories;
import com.example.productservice.repositories.ProductRepositories;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements ProductService{


    ProductRepositories productRepositories;
    private final CategoryRepositories categoryRepositories;

    SelfProductService(ProductRepositories productRepositories,
                       CategoryRepositories categoryRepositories)
    {
        this.productRepositories=productRepositories;
        this.categoryRepositories = categoryRepositories;
    }

    public List<Product> getProducts() {
        return productRepositories.findAll();
    }


    public Optional<Product> getSingleProduct(Long productId) throws NotFoundException {
        return productRepositories.findById(productId);
    }


    public Product addNewProduct(ProductDto productDto) {
        Product product=new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setImage(productDto.getImage());
        product.setDescription(productDto.getDescription());
        Category category=new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        categoryRepositories.save(category);
        return productRepositories.save(product);
    }


    public Product updateProduct(Long productId, Product product) {
        return productRepositories.save(product);
    }


    public Product replaceProduct(Long productId, Product product) {

        return productRepositories.save(product);
    }


    public Product deleteProduct(Long productId) {
        Optional<Product> product=productRepositories.findById(productId);
         productRepositories.deleteById(productId);
         return product.get();
    }
}
