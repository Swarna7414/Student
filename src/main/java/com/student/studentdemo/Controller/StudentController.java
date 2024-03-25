package com.student.studentdemo.Controller;

import com.student.studentdemo.Exception.BadRequestException;
import com.student.studentdemo.Exception.ResourceNotfoundException;
import com.student.studentdemo.Model.Student;
import com.student.studentdemo.Service.Impl.ServiceImpl;
import com.student.studentdemo.Service.StudentService;
import org.hibernate.usertype.LoggableUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realstudent")
public class StudentController {

    @Autowired
    StudentService service;
    @PostMapping
    public ResponseEntity<Object> Createdetials(@RequestBody Student student){

         try {
             ResponseEntity<?> result = service.createdetials(student);
             return new ResponseEntity<>(result, HttpStatus.CREATED);
         } catch (BadRequestException exception){
             return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
         }
    }

    @GetMapping("{roll}")
    public ResponseEntity<?> getdetails(@PathVariable Integer roll){

        try {
            Student student = service.getdetails(roll);
            return new ResponseEntity<>(student,HttpStatus.OK);
        }catch (ResourceNotfoundException exception){
            return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
        }

    }

    @GetMapping
    public List<Student> getalldetails(){
        return service.getalldetials();
    }

    @GetMapping("/sorted")
    public Student sortedone(){
        return service.highestone();
    }

    @GetMapping("/passedstudents")
    public List<String> getpassedone(@RequestParam String Subject){
        return service.passedstudents(Subject);
    }

    @GetMapping("/failedstudents")
    public List<String> failedstudnets(@RequestParam String Subject){
        return service.failedstudents(Subject);
    }

    @GetMapping("/allpassed")
    public List<Student> getallpassed(){
        return service.allpassed();
    }

    @GetMapping("/allfailed")
    public List<Student> getallfailed(){
        return service.allfailed();
    }

    @DeleteMapping("{roll}")
    public String deletedetails(@PathVariable Integer roll){
        return service.deletedetails(roll);
    }

}
