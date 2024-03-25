package com.student.studentdemo.Exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

public class BadRequestExceptionTest {

    @Test
    public void testbadrequest(){
        String message= "Bad Request";
        HttpStatus httpStatus=HttpStatus.BAD_REQUEST;

        BadRequestException badRequestException=new BadRequestException(message,httpStatus);

        assertEquals(message,badRequestException.getMessage());
        assertEquals(httpStatus,badRequestException.getStatus());

    }

}