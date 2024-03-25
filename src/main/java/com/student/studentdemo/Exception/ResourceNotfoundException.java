package com.student.studentdemo.Exception;

import org.springframework.http.HttpStatus;

public class ResourceNotfoundException extends RuntimeException{

    private final HttpStatus status;

    public ResourceNotfoundException(String message, HttpStatus status){
        super(message);
        this.status=status;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
