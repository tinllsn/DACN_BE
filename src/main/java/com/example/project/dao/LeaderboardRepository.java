//package com.example.project.dao;
//
//import com.example.project.model.Leaderboard;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface LeaderboardRepository extends JpaRepository<Leaderboard, Integer> {
//    List<Leaderboard> findAllByOrderByPointsDesc();
//}