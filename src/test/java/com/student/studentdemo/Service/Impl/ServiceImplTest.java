package com.student.studentdemo.Service.Impl;

import com.student.studentdemo.Exception.BadRequestException;
import com.student.studentdemo.Exception.ResourceNotfoundException;
import com.student.studentdemo.Model.Student;
import com.student.studentdemo.Repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private ServiceImpl service;

    private Student student;

    private Student student1;

    private Student student2;

    private Student student3;

    private Student student4=null;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setup(){
        autoCloseable= MockitoAnnotations.openMocks(this);
        Map<String,Integer> subjects=new HashMap<>();
        subjects.put("mathes",50);
        subjects.put("science",65);
        subjects.put("Social",55);

        student=new Student(20,"Swarna",25,0,subjects);

        Map<String, Integer> subjects1=new HashMap<>();

        subjects1.put("mathes",50);
        subjects1.put("science",6);
        subjects1.put("Social",5);

        student1=new Student(30,"Sai",28,0,subjects1);

        Map<String, Integer> subjects2=new HashMap<>();

        subjects2.put("mathes",95);
        subjects2.put("science",65);
        subjects2.put("Social",85);

        student3 = new Student(65,"Sankar",36,0,subjects2);

    }

    @AfterEach
    void teardown() throws Exception{
        autoCloseable.close();
    }

    @Test
    public void createdetils(){
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.save(student)).thenReturn(student);
        ResponseEntity<Object> responseEntity=service.createdetials(student);

        assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
        assertEquals("Student details has been created",responseEntity.getBody());

    }

    @Test
    public void createdetalsexception(){
        assertThrows(BadRequestException.class, () -> {service.createdetials(null);});

    }

    @Test
    public void getdetails(){
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.findById(30)).thenReturn(Optional.of(student1));
        service.getdetails(30);

        Integer non=555;
        when(studentRepository.findById(non)).thenReturn(Optional.empty());
        assertThrows(ResourceNotfoundException.class, ()->service.getdetails(non));

    }

    @Test
    public void getalldetials(){
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.findAll()).thenReturn(Arrays.asList(student,student1,student2,student3));
        service.getalldetials();
    }

    @Test
    public void gethighesone(){
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.findAll()).thenReturn(Arrays.asList(student,student1,student2,student3));
        Student result=service.highestone();
    }

    @Test
    public void testpassedstudents(){
        mock(Student.class);
        mock(StudentRepository.class);

        String sub="mathes";
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student,student1,student3));
        List<String> passeda= service.passedstudents(sub);

    }

    @Test
    public void testfailedstudents(){
        mock(Student.class);
        mock(StudentRepository.class);

        String sub="science";
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student,student1,student3));
        List<String> failed=service.failedstudents(sub);

    }

    @Test
    public void allpassed(){
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.findAll()).thenReturn(Arrays.asList(student,student1,student3));
        List<Student> passedstudents=service.allpassed();

    }

    @Test
    public void allfailed(){
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.findAll()).thenReturn(Arrays.asList(student,student1,student3));
        List<Student> failedstudents=service.allfailed();

    }

    @Test
    public void deleteone(){
        mock(Student.class);
        mock(StudentRepository.class);

        Integer roll=30;

        doNothing().when(studentRepository).deleteById(roll);

        service.deletedetails(roll);
    }



}