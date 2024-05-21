package com.example.productservice.services;

import com.example.productservice.dtos.ProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

     List<Product> getProducts();
     Optional<Product> getSingleProduct(Long productId) throws NotFoundException;
     Product addNewProduct(ProductDto productDto);
     Product updateProduct(Long productId,Product product);
     Product replaceProduct(Long productId,Product product);
     Product deleteProduct(Long productId);

}
