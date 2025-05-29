package com.example.project.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ClassificationResponse {
    private Integer id;
    private Integer userId;
    private String imageUrl;
    private String wasteType;
    private Float confidence;
    private String suggestion;
    private LocalDateTime createdAt;

    // Getters and Setters
}