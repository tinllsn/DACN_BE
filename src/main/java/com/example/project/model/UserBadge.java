//package com.example.project.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "user_badges", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "badge_id"}))
//public class UserBadge {
//
//    @EmbeddedId
//    private UserBadgeId id;
//
//    @ManyToOne
//    @MapsId("userId")
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @ManyToOne
//    @MapsId("badgeId")
//    @JoinColumn(name = "badge_id", nullable = false)
//    private Badge badge;
//
//    @Column(name = "earned_at", nullable = false, updatable = false)
//    private LocalDateTime earnedAt = LocalDateTime.now();
//
//    // Getters and Setters
//}