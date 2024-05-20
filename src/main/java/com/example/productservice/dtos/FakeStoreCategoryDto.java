package com.example.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreCategoryDto {

    private String category;

    public FakeStoreCategoryDto()
    {

    }
    public FakeStoreCategoryDto(String category)
    {
        this.category=category;
    }
}
