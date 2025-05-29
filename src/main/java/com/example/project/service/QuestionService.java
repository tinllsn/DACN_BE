package com.example.project.service;

import com.example.project.dto.QuestionDTO;
import com.example.project.model.Question;
import com.example.project.dao.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    QuestionRepository questionDao;
    public List<QuestionDTO> getAllQuestion() {

       List<Question> list = questionDao.findAll();

      return  list.stream()
              .map(item-> modelMapper.map(item, QuestionDTO.class))
              .toList();
    }

//    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
//        try {
//            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
//    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public Optional<Question> getQuestionById(Integer id) {
        return questionDao.findById(id);
    }

    public boolean deleteQuestionById(Integer id) {
        if (questionDao.existsById(id)) {
            questionDao.deleteById(id);
            return true;
        }
        return false;

    }
}
