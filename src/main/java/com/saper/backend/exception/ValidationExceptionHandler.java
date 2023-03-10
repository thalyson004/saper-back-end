package com.saper.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ErrorDTO> errors = new ArrayList<>();
        exception
                .getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    errors.add(
                            new ErrorDTO(
                                    ((FieldError) error).getField(),
                                    error.getDefaultMessage())
                    );
                });
        return errors;
    }

//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public String handle2(HttpMessageNotReadableException ex) {
//        return "Error 2";
//    }

}
