//package com.example.project.controller;
//
//import com.example.project.dto.WasteGuideRequest;
//import com.example.project.dto.WasteGuideResponse;
//import com.example.project.service.WasteGuideService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("waste-guides")
//public class WasteGuideController {
//
//    @Autowired
//    private WasteGuideService wasteGuideService;
//
//    @PostMapping
//    public ResponseEntity<WasteGuideResponse> createWasteGuide(@RequestBody WasteGuideRequest request) {
//        WasteGuideResponse response = wasteGuideService.createWasteGuide(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<WasteGuideResponse>> getAllWasteGuides() {
//        List<WasteGuideResponse> responses = wasteGuideService.getAllWasteGuides();
//        return new ResponseEntity<>(responses, HttpStatus.OK);
//    }
//
//    @GetMapping("{wasteType}")
//    public ResponseEntity<WasteGuideResponse> getWasteGuideByType(@PathVariable String wasteType) {
//        WasteGuideResponse response = wasteGuideService.getWasteGuideByType(wasteType);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//}