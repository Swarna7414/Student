package com.student.studentdemo.Exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

public class ResourceNotfoundExceptionTest {

    @Test
    public void testresousenotfound(){
        String message="Resource was not found";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        ResourceNotfoundException resourceNotfoundException=new ResourceNotfoundException(message,httpStatus);

        assertEquals(message,resourceNotfoundException.getMessage());
        assertEquals(httpStatus,resourceNotfoundException.getStatus());

    }



}