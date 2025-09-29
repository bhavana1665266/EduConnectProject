package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Enrollment;
<<<<<<< HEAD
import com.wecp.progressive.service.EnrollmentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;
    
=======
import org.springframework.http.ResponseEntity;

import java.util.List;

public class EnrollmentController {
>>>>>>> f55bf55e462e4faaa809ff6a4f28c9749421a7f1

    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        return null;
    }
<<<<<<< HEAD
    @PostMapping
    public ResponseEntity<Integer> createEnrollment(@RequestBody Enrollment enrollment) {
        return new ResponseEntity<>(enrollmentService.createEnrollment(enrollment),HttpStatus.CREATED);
=======

    public ResponseEntity<Integer> createEnrollment(Enrollment enrollment) {
        return null;
>>>>>>> f55bf55e462e4faaa809ff6a4f28c9749421a7f1
    }

    public ResponseEntity<Void> updateEnrollment(int enrollmentId, Enrollment enrollment) {
        return null;
    }

    public ResponseEntity<Enrollment> getEnrollmentById(int enrollmentId) {
        return null;
    }

    public ResponseEntity<List<Enrollment>> getAllEnrollmentsByStudent(int studentId) {
        return null;
    }

    public ResponseEntity<List<Enrollment>> getAllEnrollmentsByCourse(int courseId) {
        return null;
    }

}
