package com.student.studentdemo.Exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

public class InternalServerExceptionTest {

    @Test
    public void testInternalserverException(){
        String message = "Internal Server Exception";
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        InternalServerException internalServerException= new InternalServerException(message,httpStatus);

        assertEquals(message, internalServerException.getMessage());
        assertEquals(httpStatus,  internalServerException.getStatus());

    }
}