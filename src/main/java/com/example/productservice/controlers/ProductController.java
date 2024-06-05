package com.example.productservice.controlers;


import com.example.productservice.clients.AuthenticationClient.AuthClient;
import com.example.productservice.clients.AuthenticationClient.dtos.Role;
import com.example.productservice.clients.AuthenticationClient.dtos.SessionStatus;
import com.example.productservice.clients.AuthenticationClient.dtos.ValidateResponseDto;
import com.example.productservice.dtos.ProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.ProductRepo;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ProductRepo productRepo;
    private AuthClient authClient;


    public ProductController(ProductService productService,ProductRepo productRepo,AuthClient authClient)
    {

        this.productService=productService;
        this.productRepo=productRepo;
        this.authClient=authClient;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(@Nullable @RequestHeader("AUTH_TOKEN") String token
                                      ,@Nullable @RequestHeader("USER_ID") Long userId)
    {

        if(token==null || userId==null)
        {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

//        ValidateResponseDto validateResponseDto=authClient.validate(token,userId);
//
//       if(validateResponseDto.getSessionStatus().equals(SessionStatus.INVALID))
//       {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//
//         boolean flag=false;
//        for(Role role:validateResponseDto.getUserDto().getRoles())
//        {
//            if(role.getRole().equals("ADMIN"))
//            {
//                flag=true;
//            }
//        }
//       if(flag==true)
//       {
//          return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
//       }
//       else {
//           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//       }

//        ValidateResponseDto response = authClient.validate(token, userId);
//
//        // check if token is valid
//        if (response.getSessionStatus().equals(SessionStatus.INVALID)) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }

        // validate token
        // RestTemplate rt = new RestTRemplate();
        //  rt.get("localhost:9090/auth/validate?)

        // check if user has permissions
//        boolean isUserAdmin = false;
//        for (Role role: response.getUserDto().getRoles()) {
//            if (role.getRole().equals("ADMIN")) {
//                isUserAdmin = true;
//            }
//        }
//
//        if (!isUserAdmin) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

        List<Product> products = productService.getProducts();

//        products.get(0).setPrice(100); /// Bug induced in my code
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleproduct(@PathVariable("productId") Long productId) throws NotFoundException {
        MultiValueMap<String,String> mp=new LinkedMultiValueMap<>();
        mp.add("auth","sjgfgjsk122");

        Optional<Product> productOptional=productService.getSingleProduct(productId);

        if(productOptional.isEmpty())
        {
            throw new NotFoundException("id not found");
        }
        ResponseEntity<Product> responseEntity=new ResponseEntity<>(productOptional.get(),mp, HttpStatus.OK);
        return responseEntity;
    }
    @PostMapping()
    public ResponseEntity<Product> addNewproduct(@RequestBody ProductDto productDto)
    {

        Product newproduct=new Product();
        newproduct.setTitle(productDto.getTitle());
        newproduct.setPrice(productDto.getPrice());
        newproduct.setDescription(productDto.getDescription());
       productRepo.save(newproduct);
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
