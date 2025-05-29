package com.example.project.model;

import com.example.project.dto.ClassificationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("test")
public class test {

     @RequestMapping("")
        public ResponseEntity<?> test(@RequestBody ClassificationRequest re) {
         re.toString();
         return  new ResponseEntity<>(re, HttpStatus.OK);
        }

}
