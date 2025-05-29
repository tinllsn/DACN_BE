package com.example.project.controller;

import com.example.project.dto.AdminDTO;
import com.example.project.dto.AuthRequest;
import com.example.project.dto.UserResponse;
import com.example.project.service.AdminService;
import com.example.project.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {


    @Autowired
    private AdminService adminService;
    @PostMapping("register")
    public ResponseEntity<AdminDTO> registerUser(@RequestBody AdminDTO request){

        AdminDTO userResponse = adminService.registerUser(request);
        if (userResponse != null) {
            return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("login")
    public ResponseEntity< UserResponse> loginUser(@RequestBody AdminDTO request){
        UserResponse result = adminService.loginuser(request);
        if (result!=null){
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);

        }
    }

    ////http://localhost:8080/user?id=1
    @GetMapping("user")
    public ResponseEntity<UserResponse> getUser(@RequestParam Integer id) {

        UserResponse user = adminService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    ////http://localhost:8080/user/{id} chuan restfulAPI
    @GetMapping("user/{id}")
    public ResponseEntity<UserResponse> getUser_2(@PathVariable Integer id) {

        UserResponse user = adminService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    //
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        if (adminService.deleteUser(id)) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("update")
    public ResponseEntity<String> updateUser(@RequestBody UserResponse request) {
        String response = adminService.updateUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = adminService.getAllUsers();
        return new ResponseEntity<>(users.reversed(), HttpStatus.OK);
    }

}
