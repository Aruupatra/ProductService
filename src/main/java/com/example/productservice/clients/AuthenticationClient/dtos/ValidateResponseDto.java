package com.example.productservice.clients.AuthenticationClient.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ValidateResponseDto {
   private UserDto userDto;
   private SessionStatus sessionStatus;
}
