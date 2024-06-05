package com.example.productservice.clients.AuthenticationClient.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenRequestDto {

    private String token;
    private Long userId;
}
