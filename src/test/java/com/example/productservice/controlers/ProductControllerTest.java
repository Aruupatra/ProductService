//package com.example.productservice.controlers;
//
//import com.example.productservice.models.Product;
//import com.example.productservice.services.ProductService;
//import com.example.productservice.services.SelfProductService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class ProductControllerTest {
//   @Autowired
//    private ProductController productController;
//
////   @Autowired
////   private ProductService productService;
//
//    @MockBean
//    private ProductService productService;
//    @Test
//    void getProducts()
//    {
//        //arrange,create
//        List<Product> p=new ArrayList<>();
//        Product product1=new Product();
//        product1.setPrice(101.5);
//        p.add(product1);
//        //mockito
//        when(productService.getProducts()).thenReturn(p);
//
//        //act,call
//        List<Product> productList=productController.getAllProducts();
//
//        //assert,check
//        assertEquals(100.5, productList.get(0).getPrice());
//
////        List<Product> p = new ArrayList<>();
////        Product p1 = new Product();
////        p1.setPrice(106.95);
////        p.add(p1);
////
////        when(productService.getProducts()).thenReturn(p);
////
////        List<Product> products = productController.getAllProducts();
////
//////        assert products.get(0).getPrice() == 109.95;
////
//////        assertEquals(109.95, products.get(0).getPrice());
//////        assertTrue(products.get(0).getPrice() == 109.95);
////        assert products.get(0).getPrice() == 109.95;
//    }
//}