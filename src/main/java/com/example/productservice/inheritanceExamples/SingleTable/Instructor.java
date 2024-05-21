package com.example.productservice.inheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "singleTable_instructor")
@DiscriminatorValue("3")
public class Instructor extends User {

    private String company;
}
