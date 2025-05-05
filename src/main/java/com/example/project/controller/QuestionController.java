package com.example.project.controller;

import com.example.project.model.Question;
import com.example.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allquestion")
    public ResponseEntity<List<Question>> getAllQuestion() {
//        List<Question> q  = questionService.getAllQuestion();
        return questionService.getAllQuestion()  ;
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        return  questionService.addQuestion(question);

    }


}
