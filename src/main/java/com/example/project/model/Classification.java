package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;  // tạm dùng kiểu int, nếu có User entity thì dùng @ManyToOne

    private String imageUrl;

    private String wasteType;

    private Float confidence;

    private String suggestion;

    private LocalDateTime createdAt = LocalDateTime.now();
}
