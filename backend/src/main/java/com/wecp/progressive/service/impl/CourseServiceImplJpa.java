package com.wecp.progressive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.exception.CourseNotFoundException;
import com.wecp.progressive.repository.CourseRepository;
import com.wecp.progressive.service.CourseService;

import java.util.*;
@Service
public class CourseServiceImplJpa implements CourseService {
@Autowired
private CourseRepository courseRepository;



public CourseServiceImplJpa(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
}
public List<Course> getAllCourses() 
{
return courseRepository.findAll();
}
<<<<<<< HEAD
public Course getCourseById(int courseId)
=======
public Course getCourseById(int courseId) throws Exception
>>>>>>> f55bf55e462e4faaa809ff6a4f28c9749421a7f1
{
 Optional<Course> c=courseRepository.findById(courseId);
 if(c.isPresent()){
    return c.get();
 }
 else{
<<<<<<< HEAD
    throw new CourseNotFoundException("Course Not found");
=======
    throw new CourseNotFoundException("Not found");
>>>>>>> f55bf55e462e4faaa809ff6a4f28c9749421a7f1
 }
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
<<<<<<< HEAD
   public void deleteCourse(int courseId){
    if(courseRepository.existsById(courseId)){
        courseRepository.deleteById(courseId);
        return;
    }
    else{
        throw new CourseNotFoundException("Course Not found");
=======
   public void deleteCourse(int courseId) throws Exception
   {
    if(courseRepository.findById(courseId).isPresent()){
     courseRepository.deleteById(courseId);
>>>>>>> f55bf55e462e4faaa809ff6a4f28c9749421a7f1
    }
   }

   public List<Course> getAllCourseByTeacherId(int teacherId)
   {
    return courseRepository.findAll();
   }
}