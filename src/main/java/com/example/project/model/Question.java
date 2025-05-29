package com.example.project.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@Table (name = "question")
public class Question {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY) // cho phép tự tăng
     private Integer id;
     private String title;
     private String urlImage;
     private Integer rightAnswer;

}
