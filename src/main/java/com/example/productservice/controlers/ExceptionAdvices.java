package com.example.productservice.controlers;

import com.example.productservice.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {


     @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> any_name(Exception exception)
    {

        return  new ResponseEntity<>("Id Not Found", HttpStatus.NOT_FOUND);
    }
}
