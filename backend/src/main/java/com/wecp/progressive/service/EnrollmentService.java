package com.wecp.progressive.service;

import com.wecp.progressive.entity.Enrollment;

import java.util.List;

<<<<<<< HEAD
import org.springframework.stereotype.Service;
@Service
=======
>>>>>>> f55bf55e462e4faaa809ff6a4f28c9749421a7f1
public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();

    int createEnrollment(Enrollment enrollment);

    public void updateEnrollment(Enrollment enrollment);

    public Enrollment getEnrollmentById(int enrollmentId);

    public List<Enrollment> getAllEnrollmentsByStudent(int studentId);

    public List<Enrollment> getAllEnrollmentsByCourse(int courseId);

}
