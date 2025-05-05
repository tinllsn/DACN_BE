//package com.example.project.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "leaderboard")
//public class Leaderboard {
//
//    @Id
//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @Column(name = "points", nullable = false)
//    private int points = 0;
//
//    @Column(name = "updated_at", nullable = false)
//    private LocalDateTime updatedAt = LocalDateTime.now();
//
//    // Getters and Setters
//}