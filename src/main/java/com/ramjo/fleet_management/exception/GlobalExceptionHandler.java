package com.ramjo.fleet_management.exception;

import com.ramjo.fleet_management.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String >>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> error = new HashMap<>();
        for(FieldError e : ex.getBindingResult().getFieldErrors()){
            error.put(e.getField(), e.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(error, "Erro"));
    }

    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGenericExceptioh(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error("", ""));
    }
     */
}
