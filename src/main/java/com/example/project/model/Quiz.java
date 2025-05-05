//package com.example.project.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Entity
//@Data
//public class Quiz {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // cho phép tự tăng
//    private Integer id;
//    private String title;
//
//    @ManyToMany
//    private List<Question> questions;
//}
