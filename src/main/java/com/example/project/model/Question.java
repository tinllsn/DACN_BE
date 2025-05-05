package com.example.project.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table (name = "question")
public class Question {

     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY) // cho phép tự tăng
     private Integer id;
     private String category;
     private String dificultylevel;
     private String option1;
     private String option2;
     private String option3;
     private String option4;
     @Column(name = "question_title")
     private String questionTitle;
     @Column(name = "right_answer")
     private String rightAnswer;

}
