package com.mcfoods.mcfoodorderingsystem.exception;

import com.mcfoods.mcfoodorderingsystem.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;


@RestControllerAdvice
public class GlobalExceptionHandler {


    // 404 - Category not found
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Response<Void>> handleCategoryNotFound(CategoryNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response.error(ex.getMessage(),404));
    }


    // 400 - Bean Validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Void>> handleValidation(MethodArgumentNotValidException ex) {

        String message = Objects.requireNonNull(ex.getBindingResult()
                        .getFieldError())
                .getDefaultMessage();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Response.error( message,400));
    }
}
