//package com.example.project.controller;
//
//import com.example.project.dto.LeaderboardResponse;
//import com.example.project.service.LeaderboardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("leaderboard")
//public class LeaderboardController {
//
//    @Autowired
//    private LeaderboardService leaderboardService;
//
//    @PutMapping("update/{userId}")
//    public ResponseEntity<LeaderboardResponse> updatePoints(@PathVariable int userId, @RequestParam int points) {
//        LeaderboardResponse response = leaderboardService.updatePoints(userId, points);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<LeaderboardResponse>> getLeaderboard() {
//        List<LeaderboardResponse> responses = leaderboardService.getLeaderboard();
//        return new ResponseEntity<>(responses, HttpStatus.OK);
//    }
//}