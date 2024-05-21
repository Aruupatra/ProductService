package com.example.productservice.inheritanceExamples.mappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mappedSuper_instructor")
@PrimaryKeyJoinColumn(name="user_id")
public class Instructor extends User {

    private String company;
}
