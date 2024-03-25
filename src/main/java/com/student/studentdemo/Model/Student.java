package com.student.studentdemo.Model;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "Student_detials")
public class Student {

    @Id
    private Integer roll;

    private String name;

    private Integer age;

    private Integer marks=0;

    @ElementCollection
    @CollectionTable(name = "student_subjects",joinColumns = @JoinColumn(name = "student_roll"))
    @MapKeyColumn(name = "subject_name")
    @Column(name = "subject_marks")
    private Map<String, Integer> subjects;

    public Student() {

    }

    public Student(Integer roll, String name, Integer age, Integer marks, Map<String, Integer> subjects) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.marks=marks;
        this.subjects = subjects;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjects(Map<String, Integer> subjects) {
        this.subjects = subjects;
        updateTotalmarks();
    }

    private void updateTotalmarks(){
        if (subjects!=null){
            marks = subjects.values().stream().mapToInt(Integer::intValue).sum();
        }
        else {
            marks = 0;
        }
    }
}