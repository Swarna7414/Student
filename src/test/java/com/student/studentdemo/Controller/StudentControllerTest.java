package com.student.studentdemo.Controller;

import com.student.studentdemo.Exception.BadRequestException;
import com.student.studentdemo.Exception.ResourceNotfoundException;
import com.student.studentdemo.Model.Student;
import com.student.studentdemo.Service.Impl.ServiceImpl;
import jakarta.persistence.Enumerated;
import org.hibernate.sql.ast.tree.expression.CaseSimpleExpression;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.Provider;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class StudentControllerTest {

    @Mock
    ServiceImpl service;

    @InjectMocks
    StudentController controller;

    private Student student;

    private Student student1;

    private Student student2;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {

        autoCloseable = MockitoAnnotations.openMocks(this);

        Map<String, Integer> subjects= new HashMap<>();

        subjects.put("Math",50);
        subjects.put("Sciece",45);
        subjects.put("Social",65);

        Map<String, Integer> subjects1= new HashMap<>();

        subjects1.put("Math",40);
        subjects1.put("Science",36);
        subjects1.put("Social",55);

        Map<String, Integer> subjects3= new HashMap<>();

        subjects3.put("Math",20);
        subjects3.put("Science",25);
        subjects3.put("Social",6);

        student= new Student(25,"Swarna",25,0,subjects);

        student1 = new Student(52,"Sai Sankar",25,0,subjects1);

        student2 = new Student(89,"Sankar",56,0,subjects3);


    }

    @AfterEach
    public void tearDown() throws Exception{
        autoCloseable.close();
    }


    @Test
    public void createdetials() {
        when(service.createdetials(student)).thenReturn(new ResponseEntity<>(student,HttpStatus.CREATED));
        ResponseEntity<?> responseEntity=controller.Createdetials(student);
        assertEquals(responseEntity.getStatusCode(),HttpStatus.CREATED);

        Student student2=null;

        String errormessage="Student Details are null or one student data is missing";
        BadRequestException exception=new BadRequestException(errormessage,HttpStatus.BAD_REQUEST);
        when(service.createdetials(student2)).thenThrow(exception);
        ResponseEntity<?> errorresponse=controller.Createdetials(student2);
        assertEquals(HttpStatus.BAD_REQUEST, errorresponse.getStatusCode());
        assertEquals(errormessage, errorresponse.getBody());

    }

    @Test
    void getdetails() {
        Integer Roll=student.getRoll();
        when(service.getdetails(anyInt())).thenReturn(student);

        ResponseEntity<?> responseEntity=controller.getdetails(Roll);

        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(student,responseEntity.getBody());

        //roll+"detils not found"
        Integer nroll=599;
        String message=nroll+"detils not found";
        ResourceNotfoundException resourceNotfoundException=new ResourceNotfoundException(message,HttpStatus.NOT_FOUND);
        when(service.getdetails(nroll)).thenThrow(resourceNotfoundException);
        ResponseEntity<?> noresourse=controller.getdetails(nroll);
        assertEquals(HttpStatus.NOT_FOUND,noresourse.getStatusCode());
    }

    @Test
    void getalldetails() {

        when(service.getalldetials()).thenReturn(Arrays.asList(student,student1));

        List<Student> students=controller.getalldetails();

    }

    @Test
    void sortedone() {
        when(service.highestone()).thenReturn(student);
        Student hig=controller.sortedone();
    }

    @Test
    void getpassedone() {

        List<String> passedstudents=Arrays.asList("Swarna","Sai Sankar");
        when(service.passedstudents("Math")).thenReturn(passedstudents);
        List<String> passedone=controller.getpassedone("Math");
        assertEquals(passedone,passedstudents);

    }

    @Test
    void failedstudnets() {

        List<String> failedstudent=Arrays.asList("Sankar");
        when(service.failedstudents("Math")).thenReturn(failedstudent);
        List<String> passedone=controller.failedstudnets("Math");
    }

    @Test
    void getallpassed() {
        List<Student> passedone=Arrays.asList(student,student1);
        when(service.allpassed()).thenReturn(passedone);


        List<Student> pass=controller.getallpassed();

        assertEquals(passedone,pass);
    }

    @Test
    void getallfailed() {
        List<Student> failedone=Arrays.asList(student2);
        when(service.allfailed()).thenReturn(failedone);

        List<Student> fail=controller.getallfailed();

        assertEquals(fail,failedone);
    }

    @Test
    void deletedetails() {
        Integer roll=student.getRoll();
        String message="Student Details deleted";
        when(service.deletedetails(roll)).thenReturn(message);

        String met=controller.deletedetails(roll);

        assertEquals(message,met);
    }
}