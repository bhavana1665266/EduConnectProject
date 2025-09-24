package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Student;
import com.wecp.progressive.service.StudentService;


public class StudentServiceImplJpa implements StudentService {

    @Autowired
    private StudentService studentService;
    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentService.getAllStudents();
    }

    @Override
    public Integer addStudent(Student student) {
       return studentService.addStudent(student);
    }

    @Override
    public List<Student> getAllStudentSortedByName() {
        return studentService.getAllStudentSortedByName();
    }
   



}