package com.example.productservice.inheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "singleTable_TA")
@DiscriminatorValue("1")
public class TA extends User {

   private int grad_Year;
}
