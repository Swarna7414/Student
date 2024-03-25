package com.student.studentdemo.Model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class StudentTest {

    @Test
    public void test(){
        Integer roll=25;
        String name="Swarna sai sankar";
        Integer age=25;
        Map<String, Integer> subjects= new HashMap<>();
        subjects.put("Math",20);
        subjects.put("Science",55);
        subjects.put("Social",55);
        Student oo=new Student();
        Student o=new Student(20,"Swarna",22,350,subjects);

        o.setRoll(20);
        o.setName("Swarna");
        o.setAge(22);
        o.setMarks(135);
        o.setSubjects(subjects);

        o.getRoll();
        o.getName();
        o.getAge();
        o.getMarks();
        o.getSubjects();
        o.setMarks(0);
        o.getSubjects();

    }

}