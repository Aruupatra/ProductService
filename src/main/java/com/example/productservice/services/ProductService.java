package com.example.productservice.services;

import com.example.productservice.dtos.ProductDto;
import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {

     List<Product> getProducts();
     Product getSingleProduct(Long productId);
     Product addNewProduct(ProductDto productDto);
     Product updateProduct(Long productId,Product product);
     Product replaceProduct(Long productId,Product product);
     Product deleteProduct(Long productId);

}
