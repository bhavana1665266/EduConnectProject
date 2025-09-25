package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.service.impl.TeacherServiceImplArraylist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


public class TeacherController  {
 
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return null;
    }

    public ResponseEntity<Teacher> getTeacherById(int teacherId) {
        return null;
    }

    public ResponseEntity<Integer> addTeacher(Teacher teacher) {
        return null;
    }
  

   @PutMapping("/{teacherId}")
    public ResponseEntity<Void> updateTeacher(int teacherId, Teacher teacher) throws Exception{
        return new ResponseEntity<>(HttpStatus.OK);
        
    }

    public ResponseEntity<Void> deleteTeacher(int teacherId) {
        return null;
    }

    public ResponseEntity<List<Teacher>> getTeacherSortedByYearsOfExperience() {
        return null;
    }
}
