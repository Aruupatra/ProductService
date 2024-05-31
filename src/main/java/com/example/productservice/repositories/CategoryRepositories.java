package com.example.productservice.repositories;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepositories extends JpaRepository<Category,Long> {

   public Category save(Category category);

    public Optional<Category> findById(Long id);
    public List<Category> findAllByIdIn(List<Long> ids);
    //JPA Query
    @Query(value="select p from Product p where p.category.name= :name")
    public List<Product> findProductByCategoryName(String name);

    //Native Query
    @Query(value="select * from Category c",nativeQuery = true)
    public List<Category> findAll();
}
