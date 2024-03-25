package com.student.studentdemo.Service.Impl;

import com.student.studentdemo.Exception.BadRequestException;
import com.student.studentdemo.Exception.ResourceNotfoundException;
import com.student.studentdemo.Model.Student;
import com.student.studentdemo.Repository.StudentRepository;
import com.student.studentdemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseEntity<Object> createdetials(Student student) {

        if (student==null){
            throw new BadRequestException("Student Details are null or one student data is missing", HttpStatus.BAD_REQUEST);
        }
        studentRepository.save(student);
        return new ResponseEntity<>("Student details has been created",HttpStatus.CREATED);
    }

    @Override
    public Student getdetails(Integer roll) {
        Optional<Student> singledetail = studentRepository.findById(roll);

        if (singledetail.isPresent()){
            return singledetail.get();
        } else {
            throw new ResourceNotfoundException(roll+"detils not found",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Student> getalldetials() {
        return studentRepository.findAll();
    }

    @Override
    public Student highestone() {
        Optional<Student> allstudent=studentRepository.findAll().stream().max(Comparator.comparingInt(Student::getMarks));
        return allstudent.orElse(null);
    }

    @Override
    public List<String> passedstudents(String subject) {
        List<Student> allstudents=studentRepository.findAll();

        List<Student> passed =allstudents.stream().filter(n->n.getSubjects().containsKey(subject) && n.getSubjects().get(subject)>=35).collect(Collectors.toList());

        return passed.stream().map(Student::getName).collect(Collectors.toList());

    }

    @Override
    public List<String> failedstudents(String subject) {
        List<Student> allstudents=studentRepository.findAll();

        List<Student> failedstudents = allstudents.stream().filter(n->n.getSubjects().containsKey(subject) && n.getSubjects().get(subject)<35).collect(Collectors.toList());

        return failedstudents.stream().map(Student::getName).collect(Collectors.toList());
    }

    @Override
    public List<Student> allpassed() {
        List<Student> allstudents=studentRepository.findAll();
        List<Student> passedone=new ArrayList<>();

        for (Student student: allstudents){
            boolean pass=true;

            for (int marks: student.getSubjects().values()){
                if (marks<=35){
                    pass=false;
                    break;
                }
            }

            if (pass){
                passedone.add(student);
            }
        }

        return passedone;
    }

    @Override
    public List<Student> allfailed() {

        List<Student> allstudent=studentRepository.findAll();
        List<Student> failedone=new ArrayList<>();

        for (Student student: allstudent){
            boolean fail=true;

            for (int marks:student.getSubjects().values()){
                if (marks>35){
                    fail=false;
                    break;
                }
            }

            if(fail){
                failedone.add(student);
            }
        }

        return failedone;
    }

    @Override
    public String deletedetails(Integer roll) {
        studentRepository.deleteById(roll);
        return "Student Details deleted";
    }

}
