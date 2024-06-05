package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreCategoryDto;
import com.example.productservice.clients.FakeStore.FakeStoreProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeCategoriesServiceImpl implements CategoryService{

    RestTemplateBuilder restTemplateBuilder;
    public FakeCategoriesServiceImpl(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder=restTemplateBuilder;
    }
    public Category convertFakeStoreDtostoCategory(FakeStoreCategoryDto fakeStoreCategoryDto)
    {
        Category category=new Category();
       category.setName(fakeStoreCategoryDto.getCategory());
       return category;
    }
    @Override
    public List<Category> getAllCategories() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreCategoryDto[]> responseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products/categories",FakeStoreCategoryDto[].class);



        List<Category> answer=new ArrayList<>();
        for(FakeStoreCategoryDto fakeStoreCategoryDto:responseEntity.getBody())
        {
            answer.add(convertFakeStoreDtostoCategory(fakeStoreCategoryDto));
        }
        return answer;
    }
    public Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto)
    {

        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category=new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setImage(fakeStoreProductDto.getImage());
        return product;
    }
    @Override
    public List<Product> getProductsInCategory(String categoryName) {

        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products/category/{name}",FakeStoreProductDto[].class,categoryName);

        List<Product> answer=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:responseEntity.getBody())
        {
            answer.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return answer;
    }
}
