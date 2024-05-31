package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends Basemodel{


    private String name;
    private String description;

    @OneToMany(mappedBy = "category",cascade={CascadeType.PERSIST})
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> products;
}
