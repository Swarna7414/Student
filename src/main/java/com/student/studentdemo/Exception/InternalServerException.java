package com.student.studentdemo.Exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends RuntimeException{

    private final HttpStatus status;

    public InternalServerException(String message, HttpStatus status){
        super(message);
        this.status=status;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
