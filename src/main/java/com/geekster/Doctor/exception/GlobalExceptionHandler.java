package com.geekster.Doctor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> methodArgumentException(MethodArgumentNotValidException ex){
        BindingResult bindResult = ex.getBindingResult();
        List<ObjectError> allErrors = bindResult.getAllErrors();
        Map<String,String> erroList = new HashMap<>();
        for(ObjectError error:allErrors){
            String message = error.getDefaultMessage();
            String field = ((FieldError)error).getField();
            erroList.put(field,message);
        }
        return erroList;
    }

    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity<String> recordnotfound(RecordNotFound ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
