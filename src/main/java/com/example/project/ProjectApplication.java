package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collector;
import java.util.stream.Collectors;

//@RestController
@SpringBootApplication
public class ProjectApplication {


//	@Autowired
//	QuestionRepo qe;
//	@GetMapping("/test")
//	public String test(){
//		return qe.findAll().stream().collect((Collectors.toList())).toString();
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
