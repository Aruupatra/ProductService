package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepositories extends JpaRepository<Product,Long> {


    public Product save(Product product);
    public Optional<Product> findById(Long id);
   // public Optional<Product> updateByIdIn(Long id,Product product);

    public List<Product> findProductByCategory_NameAndCategoryId(String CategoryName,Long CategoryId);

    @Query(value = Queries.laoProductQueuey,nativeQuery = true)
    public List<Product> laoProductById(Long id);

    @Query("select p from Product p where p.id = :productId and p.category.name = :categoryName")
     public List<Product> getProductsByProductIdandCategoryName(Long productId,String categoryName);

//    @Query("select p.title from Product p where p.id = :id and p.category.name = :categoryName")
//    public List<Product> getByIdAndTitle(Long id, String categoryName);
}
