package com.nexcart.product_service.exception;

import com.nexcart.product_service.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> hundleValidationException(MethodArgumentNotValidException ex){
       // return ResponseEntity.badRequest().body("Validation failed");
        Map<String,String>errors=new HashMap<>();

        ex.getBindingResult().
                getFieldErrors()
                .forEach(error->errors.put(error.getField(),
                        error.getDefaultMessage()));


        ErrorResponse response=new ErrorResponse(
                400,
                "Validation Failed",
                errors
        );

        return ResponseEntity.badRequest().body(response);





    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse>hundleProductNotFound(ProductNotFoundException ex){
        ErrorResponse response=new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                Map.of());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }





}
