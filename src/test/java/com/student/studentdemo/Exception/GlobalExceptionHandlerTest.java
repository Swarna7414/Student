package com.student.studentdemo.Exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionHandlerTest {

    @Test
    public void testHandleResourcenotfoundException(){
        String message= "Resource Not found";
        HttpStatus status=HttpStatus.NOT_FOUND;

        ResourceNotfoundException resourceNotfoundException=new ResourceNotfoundException(message,status);

        GlobalExceptionHandler globalExceptionHandler=new GlobalExceptionHandler();
        ResponseEntity<?> responseEntity=globalExceptionHandler.handleresourcenotfoundexception(resourceNotfoundException);

        assertEquals(message, responseEntity.getBody());
        assertEquals(status,responseEntity.getStatusCode());

    }

    @Test
    public void testBadRequest(){
        String message= "BadRequest";
        HttpStatus status=HttpStatus.BAD_REQUEST;

        BadRequestException badRequestException=new BadRequestException(message,status);

        GlobalExceptionHandler globalExceptionHandler=new GlobalExceptionHandler();
        ResponseEntity<?> responseEntity=globalExceptionHandler.handlebadrequestexception(badRequestException);

        assertEquals(message, responseEntity.getBody());
        assertEquals(status,responseEntity.getStatusCode());

    }

    @Test
    public void testInternalserver(){
        String message= "Internal Server";
        HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;

        InternalServerException internalServerException=new InternalServerException(message,status);

        GlobalExceptionHandler globalExceptionHandler=new GlobalExceptionHandler();
        ResponseEntity<?> responseEntity=globalExceptionHandler.handleinternalserverexception(internalServerException);

        assertEquals(message, responseEntity.getBody());
        assertEquals(status,responseEntity.getStatusCode());

    }

    @Test
    public void testgloabal(){
        String message= "Internal Server Exception";
        HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;

        InternalServerException internalServerException=new InternalServerException(message,status);

        GlobalExceptionHandler globalExceptionHandler=new GlobalExceptionHandler();
        ResponseEntity<?> responseEntity=globalExceptionHandler.handleGlobleException(internalServerException);

        assertEquals(message, responseEntity.getBody());
        assertEquals(status,responseEntity.getStatusCode());

    }



}