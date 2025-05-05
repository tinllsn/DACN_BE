package com.example.project.dto;

import java.time.LocalDateTime;

public class ClassificationResponse {
    private int id;
    private int userId;
    private String imageUrl;
    private String wasteType;
    private float confidence;
    private String suggestion;
    private LocalDateTime createdAt;

    // Getters and Setters
}