package com.example.project.dto;

import lombok.Data;

@Data
public class ClassificationRequest {
    private int userId;
    private String imageUrl;
    private String wasteType;
    private float confidence;
    private String suggestion;

    // Getters and Setters
}