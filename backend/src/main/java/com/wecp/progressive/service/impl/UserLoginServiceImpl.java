package com.wecp.progressive.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wecp.progressive.dto.UserRegistrationDTO;
import com.wecp.progressive.entity.Student;
import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.entity.User;
import com.wecp.progressive.repository.StudentRepository;
import com.wecp.progressive.repository.TeacherRepository;
import com.wecp.progressive.repository.UserRepository;
 @Service
public class UserLoginServiceImpl implements UserDetailsService{
 
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
   public  User createUser(User user) {
     return userRepository.save(user);
    }
 
   public  User getUserByUsername(String username) {
    return userRepository.findByUsername(username);
    }
 
   public void registerUser(UserRegistrationDTO userRegistrationDTO) throws Exception{
       if(userRepository.findByUsername(userRegistrationDTO.getUsername())!=null){
        throw new Exception("Username already exists");
       }
       User user=new User();
       user.setUsername(userRegistrationDTO.getUsername());
       user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
       user.setRole(userRegistrationDTO.getRole());
       if("STUDENT".equalsIgnoreCase(userRegistrationDTO.getRole())){
        Student student=new Student();
        student.setFullName(userRegistrationDTO.getFullName());
        student.setContactNumber(userRegistrationDTO.getContactNumber());
        student.setEmail(userRegistrationDTO.getEmail());
        student.setAddress(userRegistrationDTO.getAddress());
        student.setDateOfBirth(userRegistrationDTO.getDateOfBirth());
        studentRepository.save(student);
        user.setStudent(student);
       }

       if("TEACHER".equalsIgnoreCase(userRegistrationDTO.getRole())){
        Teacher teacher=new Teacher();
        teacher.setFullName(userRegistrationDTO.getFullName());
        teacher.setContactNumber(userRegistrationDTO.getContactNumber());
        teacher.setEmail(userRegistrationDTO.getEmail());
        teacher.setSubject(userRegistrationDTO.getSubject());
        teacher.setYearsOfExperience(userRegistrationDTO.getYearsOfExperience());
        teacherRepository.save(teacher);
        user.setTeacher(teacher);
       }

       userRepository.save(user);

 
    }
 
         public  User getUserDetails(int userId) {
          if(!userRepository.findById(userId).isPresent()){
            throw new UsernameNotFoundException("User not found with ID: "+userId);
          }
           return userRepository.findById(userId).get();
    }
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
      User user=userRepository.findByUsername(username);
      if(user==null){
        throw new UsernameNotFoundException("User not found");
      }
      return org.springframework.security.core.userdetails.User
      .withUsername(user.getUsername())
      .password(user.getPassword())
      .roles(user.getRole())
      .build();

    }

    public User getUserByUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByUsername'");
    }
}
 
 
