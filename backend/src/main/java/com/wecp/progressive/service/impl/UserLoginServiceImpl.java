package com.wecp.progressive.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wecp.progressive.dto.UserRegistrationDTO;
import com.wecp.progressive.entity.User;
import com.wecp.progressive.repository.UserRepository;
 @Service
public class UserLoginServiceImpl implements UserDetailsService{
 
    @Autowired
    private UserRepository userRepository;
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

       userRepository.save(user);

 
    }
 
         public  User getUserDetails(int userId) {
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
}
 
 
