//package com.example.project.controller;
//
//import com.example.project.dto.BadgeRequest;
//import com.example.project.dto.BadgeResponse;
//import com.example.project.service.BadgeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("badges")
//public class BadgeController {
//
//    @Autowired
//    private BadgeService badgeService;
//
//    @PostMapping
//    public ResponseEntity<BadgeResponse> createBadge(@RequestBody BadgeRequest request) {
//        BadgeResponse response = badgeService.createBadge(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<BadgeResponse>> getAllBadges() {
//        List<BadgeResponse> responses = badgeService.getAllBadges();
//        return new ResponseEntity<>(responses, HttpStatus.OK);
//    }
//}