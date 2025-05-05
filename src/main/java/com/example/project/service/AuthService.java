package com.example.project.service;

import com.example.project.dao.UserRepository;
import com.example.project.dto.AuthRequest;
import com.example.project.dto.UserResponse;
import com.example.project.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
     private  UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ModelMapper modelMapper;


    public UserResponse registerUser(AuthRequest request){
        if(userRepository.findByUserName(request.getUsername()).isPresent()){
            return null;
        }

        String encodPass = bCryptPasswordEncoder.encode(request.getPassword());

        User newUser = modelMapper.map(request, User.class);
        newUser.setPassWord(encodPass);
        userRepository.save(newUser);

        return modelMapper.map(newUser, UserResponse.class);
    }

    public UserResponse loginuser(AuthRequest request){
        User user = userRepository.findByUserName(request.getUsername()).orElseThrow(()-> new RuntimeException("User not found"));
        if (bCryptPasswordEncoder.matches(request.getPassword(),user.getPassWord())){
            return modelMapper.map(user,UserResponse.class);

        } else {
            return null;
        }
    }

}
