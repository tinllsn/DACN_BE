package com.example.project.dao;

import com.example.project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

//    List<Question> findByCategory(String category);

//    @Query(value = "SELECT TOP (:numQ) * FROM question q WHERE q.category = :category ORDER BY NEWID()", nativeQuery = true)
//    List<Question> findRandomQuestionByCategory(String category, int numQ);
//@Query(value = "SELECT TOP(:numQ) * FROM question WHERE category = :category ORDER BY NEWID()", nativeQuery = true)
//List<Question> findRandomQuestionByCategory(@Param("category") String category, @Param("numQ") int numQ);

}
