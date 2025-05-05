//package com.example.project.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "waste_guides")
//public class WasteGuide {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(name = "waste_type", nullable = false, unique = true)
//    private String wasteType;
//
//    @Column(name = "description", columnDefinition = "TEXT")
//    private String description;
//
//    @Column(name = "disposal_method", columnDefinition = "TEXT")
//    private String disposalMethod;
//
//    @Column(name = "image_url")
//    private String imageUrl;
//
//    // Getters and Setters
//}