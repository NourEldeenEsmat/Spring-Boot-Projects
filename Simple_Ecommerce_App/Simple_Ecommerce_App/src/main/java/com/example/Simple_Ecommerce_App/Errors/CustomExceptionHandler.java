package com.example.Simple_Ecommerce_App.Errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@ControllerAdvice()
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handelNotFound(RecordNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getLocalizedMessage(), Arrays.asList(e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(DoubleRecordException.class)
    public ResponseEntity<?> handleDouble(DoubleRecordException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getLocalizedMessage(), Arrays.asList(e.getMessage()));
        return ResponseEntity.status(HttpStatus.FOUND).body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}
