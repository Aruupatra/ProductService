package com.example.productservice.inheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "singleTable_mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    private int no_of_sessions;
}
