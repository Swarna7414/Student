package com.student.studentdemo.Repository;

import com.student.studentdemo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}