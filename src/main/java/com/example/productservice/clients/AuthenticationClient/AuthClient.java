package com.example.productservice.clients.AuthenticationClient;

import com.example.productservice.clients.AuthenticationClient.dtos.ValidateResponseDto;
import com.example.productservice.clients.AuthenticationClient.dtos.ValidateTokenRequestDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthClient {

     private RestTemplateBuilder restTemplateBuilder;

     public AuthClient(RestTemplateBuilder restTemplateBuilder)
     {
         this.restTemplateBuilder=restTemplateBuilder;
     }
    public ValidateResponseDto validate(String token, Long userId)
    {

        RestTemplate restTemplate=restTemplateBuilder.build();

        ValidateTokenRequestDto validateTokenRequestDto=new ValidateTokenRequestDto();
        validateTokenRequestDto.setToken(token);
        validateTokenRequestDto.setUserId(userId);
        ResponseEntity<ValidateResponseDto> responseEntity=restTemplate.postForEntity("http://localhost:9000/auth/validate",validateTokenRequestDto,ValidateResponseDto.class);
         System.out.println(responseEntity.getBody().getSessionStatus());
        return responseEntity.getBody();

    }
}
