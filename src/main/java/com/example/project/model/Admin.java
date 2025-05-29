package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Data
@Table(name ="admin")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String passWord;  // Sử dụng mã hóa (ví dụ: BCrypt)
    private String email;
    private String phone;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Tự động gán createdAt khi tạo mới
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }
}
