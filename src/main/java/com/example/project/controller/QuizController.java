//package com.example.project.controller;
//
//import com.example.project.model.Question;
//import com.example.project.model.QuestionWrapper;
//import com.example.project.service.QuizService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("quiz")
//public class QuizController {
//
//    @Autowired
//    QuizService quizService;
//    @PostMapping("create")
//    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
//
//
//        return  quizService.creatQUize(category, numQ, title);
////                new ResponseEntity<>("here" + category + numQ + title ,HttpStatus.CREATED);
//
//    }
//
//    @GetMapping("get/{id}")
//    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
//        return quizService.getQuizQuestions(id);
//    }
//}
