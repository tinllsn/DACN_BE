//package com.example.project.controller;
//
//import com.example.project.dto.FeedbackRequest;
//import com.example.project.dto.FeedbackResponse;
//import com.example.project.service.FeedbackService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("feedbacks")
//public class FeedbackController {
//
//    @Autowired
//    private FeedbackService feedbackService;
//
//    @PostMapping
//    public ResponseEntity<FeedbackResponse> createFeedback(@RequestBody FeedbackRequest request) {
//        FeedbackResponse response = feedbackService.createFeedback(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    @GetMapping("classification/{classificationId}")
//    public ResponseEntity<List<FeedbackResponse>> getFeedbacksByClassificationId(@PathVariable int classificationId) {
//        List<FeedbackResponse> responses = feedbackService.getFeedbacksByClassificationId(classificationId);
//        return new ResponseEntity<>(responses, HttpStatus.OK);
//    }
//}
