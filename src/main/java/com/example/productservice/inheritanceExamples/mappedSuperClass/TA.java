package com.example.productservice.inheritanceExamples.mappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mappedSuper_TA")

public class TA extends User {

   private int grad_Year;
}
