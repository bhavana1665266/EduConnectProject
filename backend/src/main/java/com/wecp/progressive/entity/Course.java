package com.wecp.progressive.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int courseId;
private String courseName;
private String description;

@ManyToOne(cascade = CascadeType.MERGE)
@JoinColumn(name = "teacher_id")
private Teacher teacher;
//private int teacherId;

public Course() {
}
public Course(int courseId, String courseName, String description, int teacherId) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.description = description;
    this.teacher.setTeacherId(teacherId);
}
public Course(int courseId, String courseName, String description, Teacher teacher) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.description = description;
    this.teacher = teacher;
}


public int getCourseId() {
    return courseId;
}

public void setCourseId(int courseId) {
    this.courseId = courseId;
}

public String getCourseName() {
    return courseName;
}

public void setCourseName(String courseName) {
    this.courseName = courseName;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public Teacher getTeacher(){
    return teacher;
}

public void setTeacherId(Teacher teacher) {
    this.teacher = teacher;
}





}