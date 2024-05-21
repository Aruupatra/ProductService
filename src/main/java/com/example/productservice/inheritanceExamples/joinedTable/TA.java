package com.example.productservice.inheritanceExamples.joinedTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "joinTable_TA")
@PrimaryKeyJoinColumn(name="user_id")
public class TA extends User {

   private int grad_Year;
}
