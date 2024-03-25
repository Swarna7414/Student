package com.student.studentdemo.Controller;

import com.student.studentdemo.Model.Student;
import com.student.studentdemo.Service.Impl.ServiceImpl;
import org.hibernate.sql.ast.tree.expression.CaseSimpleExpression;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.Provider;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentControllerTest {

    @Mock
    ServiceImpl service;

    @InjectMocks
    StudentController controller;

    private Student student;

    private Student student1;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {

        autoCloseable = MockitoAnnotations.openMocks(this);

        Map<String, Integer> subjects= new HashMap<>();

        subjects.put("Math",50);
        subjects.put("Sciece",45);
        subjects.put("Social",65);

        Map<String, Integer> subjects1= new HashMap<>();

        subjects1.put("Math",30);
        subjects1.put("Science",36);
        subjects1.put("Social",55);

        student= new Student(25,"Swarna",25,0,subjects);

        student1 = new Student(52,"Sai Sankar",25,0,subjects1);

    }

    @AfterEach
    public void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    public void createdetials() {
        when(service.createdetials(student)).thenReturn(new ResponseEntity<>(student, HttpStatus.CREATED));

        ResponseEntity<?> responseEntity= controller.Createdetials(student);
        assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
        assertEquals(student,responseEntity.getBody());


    }

    @Test
    void getdetails() {
    }

    @Test
    void getalldetails() {
    }

    @Test
    void sortedone() {
    }

    @Test
    void getpassedone() {
    }

    @Test
    void failedstudnets() {
    }

    @Test
    void getallpassed() {
    }

    @Test
    void getallfailed() {
    }

    @Test
    void deletedetails() {
    }
}