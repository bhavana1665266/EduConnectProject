package com.wecp.progressive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.exception.CourseNotFoundException;
import com.wecp.progressive.repository.AttendanceRepository;
import com.wecp.progressive.repository.CourseRepository;
import com.wecp.progressive.service.CourseService;

import java.util.*;
@Service
public class CourseServiceImplJpa implements CourseService {
@Autowired
private CourseRepository courseRepository;
@Autowired
private AttendanceRepository attendanceRepository;



public CourseServiceImplJpa(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
}
public List<Course> getAllCourses() 
{
return courseRepository.findAll();
}
public Course getCourseById(int courseId) throws Exception{
    // if(courseRepository.findById(courseId).isEmpty()){
    //     throw new CourseNotFoundException("Not found");
    // }
    return courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Not Found"));
        
}
 
public Integer addCourse(Course course)
{
    Course c=courseRepository.save(course);
    return c.getCourseId();
}
public void updateCourse(Course course) throws Exception{
    if(courseRepository.findById(course.getCourseId()).get()!=null)
    {
        courseRepository.save(course);
    }
    else
    {
        throw new Exception("course id"+ course.getCourseId() +"not found");
    }
}
   public void deleteCourse(int courseId) throws Exception{
   if(courseRepository.findById(courseId).isPresent()){
        courseRepository.deleteById(courseId);
   }
   else{
        throw new CourseNotFoundException("Course Not found");
   }
    
   }

   public List<Course> getAllCourseByTeacherId(int teacherId)
   {
    return courseRepository.findAll();
   }
}