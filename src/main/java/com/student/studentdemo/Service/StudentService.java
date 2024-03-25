package com.student.studentdemo.Service;

import com.student.studentdemo.Model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface StudentService {
    public ResponseEntity<Object> createdetials(Student student);

    public Student getdetails(Integer roll);

    public List<Student> getalldetials();

    public Student highestone();

    public List<String> passedstudents(String subject);

    public List<String> failedstudents(String subject);

    public List<Student> allpassed();

    public List<Student> allfailed();

    public String deletedetails(Integer roll);

}
