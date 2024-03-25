package com.student.studentdemo.Exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{
    private final HttpStatus status;

    public BadRequestException(String message, HttpStatus status){
        super(message);
        this.status=status;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
