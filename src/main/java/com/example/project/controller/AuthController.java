package com.example.project.controller;

import com.example.project.dto.AuthRequest;
import com.example.project.dto.UserResponse;
import com.example.project.model.User;
import com.example.project.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @PostMapping("register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody AuthRequest request){

        UserResponse userResponse = authService.registerUser(request);
        if (userResponse != null) {
            return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("login")
    public ResponseEntity< UserResponse> loginUser(@RequestBody AuthRequest request){
        UserResponse result = authService.loginuser(request);
        if (result!=null){
        return new ResponseEntity<>(result,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);

        }
    }
}
