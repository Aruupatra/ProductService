package com.example.productservice.inheritanceExamples.joinedTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "joinTable_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
    private int no_of_sessions;
}
