package com.webApi.MyWebApi.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArith(ArithmeticException arithmeticException){
        return new ResponseEntity<String>("Divide by Zero Exception!", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException){
        return new ResponseEntity<String>("No Such data in DB. Please check the ID.", HttpStatus.NOT_FOUND);
    }

}
