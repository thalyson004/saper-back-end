package com.saper.backend.exception;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDTO> handleNotValid(MethodArgumentNotValidException exception, HttpServletRequest request) {
        List<ErrorDTO> errors = new ArrayList<>();
        exception
                .getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    errors.add(new ErrorDTO(
                                Instant.now(),
                                HttpStatus.BAD_REQUEST.toString(),
                                ((FieldError) error).getField(),
                                error.getDefaultMessage(),
                            request.getRequestURI()));
                });
        return errors;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ErrorDTO handleException(Exception exception, HttpServletRequest request) {
        System.out.println(exception);
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimeStamp(Instant.now());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.toString());
        errorDTO.setError("resource not found");
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setPath(request.getRequestURI());
        return errorDTO;
    }

//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ErrorDTO handleNoteReadable(HttpMessageNotReadableException exception) {
//        return new ErrorDTO("http message not readable", exception.getMessage());
//    }

//    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(NullPointerException.class)
//    public ErrorDTO handleNullPointerException(NullPointerException exception) {
//        return new ErrorDTO("handleNullPointerException", exception.getMessage());
//    }

//    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public ErrorDTO handleException(Exception exception) {
//        return new ErrorDTO(exception.getCause().toString(), exception.getMessage() + exception.getClass());
//    }
}
