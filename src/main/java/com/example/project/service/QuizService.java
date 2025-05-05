//package com.example.project.service;
//
//import com.example.project.dao.QuestionDao;
//import com.example.project.dao.QuizDao;
//import com.example.project.model.Question;
//import com.example.project.model.QuestionWrapper;
//import com.example.project.model.Quiz;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class QuizService {
//    @Autowired
//    QuizDao quizDao;
//
//    @Autowired
//    QuestionDao questionDao;
//    public ResponseEntity<String> creatQUize(String category, int numQ, String title) {
//        List<Question>  questions= questionDao.findRandomQuestionByCategory(category,numQ);
//
//        Quiz quiz = new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//        quizDao.save(quiz);
//        return new ResponseEntity<>("success", HttpStatus.CREATED);
//    }
//
//    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
//        Optional<Quiz> quiz = quizDao.findById(id);
//        List<Question> questionsFromDB = quiz.get().getQuestions();
//        List<QuestionWrapper> questionForUser = new ArrayList<>();
//        for(Question q: questionsFromDB) {
//            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getCategory(),q.getDificultylevel(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//            questionForUser.add(qw);
//        }
//
//        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
//    }
//}
