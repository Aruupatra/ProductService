package com.example.productservice.controlers;


import com.example.productservice.dtos.ProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.ProductRepo;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ProductRepo productRepo;

    public ProductController(ProductService productService)
    {
       // this.productRepo=productRepo;
        this.productService=productService;
    }

    @GetMapping()
    public List<Product> getAllProducts()
    {
       return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleproduct(@PathVariable("productId") Long productId)
    {
        MultiValueMap<String,String> mp=new LinkedMultiValueMap<>();
        mp.add("auth","sjgfgjsk122");
        ResponseEntity<Product> responseEntity=new ResponseEntity<>(productService.getSingleProduct(productId),mp, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @PostMapping()
    public ResponseEntity<Product> addNewproduct(@RequestBody ProductDto productDto)
    {

        ResponseEntity<Product> responseEntity=new ResponseEntity<>(productService.addNewProduct(productDto),HttpStatus.OK);

        return responseEntity;
    }

    @PatchMapping("/{productId}")
    public Product  updateAproduct(@RequestBody ProductDto productDto,@PathVariable("productId") Long productId)
    {
//        Product product=new Product();
//        product.setTitle(productDto.getTitle());
//        product.setImage(productDto.getImage());
//        product.setPrice(productDto.getPrice());
//        product.setDescription(productDto.getDescription());
//        product.setCategory(product.getCategory());
        Product product = new Product();

        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        return productService.updateProduct(productId,product);
    }

    @DeleteMapping("/{productId}")
    public Product deleteAProduct(@PathVariable("productId") Long productId)
    {

        return productService.deleteProduct(productId);
    }
}
