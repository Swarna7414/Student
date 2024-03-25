package com.student.studentdemo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotfoundException.class)
    public ResponseEntity<?> handleresourcenotfoundexception(ResourceNotfoundException ex){
        return new ResponseEntity<>(ex.getMessage(),ex.getStatus());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handlebadrequestexception(BadRequestException ex){
        return new ResponseEntity<>(ex.getMessage(),ex.getStatus());
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<?> handleinternalserverexception(InternalServerException internalServerException){
        return new ResponseEntity<>(internalServerException.getMessage(),internalServerException.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobleException(Exception exception){
        return new ResponseEntity<>("Internal Server Exception", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
