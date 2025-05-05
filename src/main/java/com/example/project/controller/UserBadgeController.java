//package com.example.project.controller;
//
//import com.example.project.dto.UserBadgeRequest;
//import com.example.project.dto.UserBadgeResponse;
//import com.example.project.service.UserBadgeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("user-badges")
//public class UserBadgeController {
//
//    @Autowired
//    private UserBadgeService userBadgeService;
//
//    @PostMapping
//    public ResponseEntity<UserBadgeResponse> assignBadgeToUser(@RequestBody UserBadgeRequest request) {
//        UserBadgeResponse response = userBadgeService.assignBadgeToUser(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    @GetMapping("user/{userId}")
//    public ResponseEntity<List<UserBadgeResponse>> getBadgesByUserId(@PathVariable int userId) {
//        List<UserBadgeResponse> responses = userBadgeService.getBadgesByUserId(userId);
//        return new ResponseEntity<>(responses, HttpStatus.OK);
//    }
//}