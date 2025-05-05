//package com.example.project.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "feedbacks")
//@Data
//public class Feedback {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "classification_id", nullable = false)
//    private Classification classification;
//
//    @Column(name = "is_correct", nullable = false)
//    private boolean isCorrect;
//
//    @Column(name = "comment", columnDefinition = "TEXT")
//    private String comment;
//
//    @Column(name = "created_at", nullable = false, updatable = false)
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    // Getters and Setters
//}