//package com.example.project.service;
//
//import com.example.project.dao.LeaderboardRepository;
//import com.example.project.dao.UserRepository;
//import com.example.project.dto.LeaderboardResponse;
//import com.example.project.model.Leaderboard;
//import com.example.project.model.User;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class LeaderboardService {
//
//    @Autowired
//    private LeaderboardRepository leaderboardRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public LeaderboardResponse updatePoints(int userId, int points) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Leaderboard leaderboard = leaderboardRepository.findById(userId)
//                .orElse(new Leaderboard());
//        leaderboard.setUser(user);
//        leaderboard.setPoints(leaderboard.getPoints() + points);
//        leaderboard.setUpdatedAt(LocalDateTime.now());
//
//        Leaderboard savedLeaderboard = leaderboardRepository.save(leaderboard);
//        return modelMapper.map(savedLeaderboard, LeaderboardResponse.class);
//    }
//
//    public List<LeaderboardResponse> getLeaderboard() {
//        List<Leaderboard> leaderboardList = leaderboardRepository.findAllByOrderByPointsDesc();
//        return leaderboardList.stream()
//                .map(entry -> modelMapper.map(entry, LeaderboardResponse.class))
//                .collect(Collectors.toList());
//    }
//}