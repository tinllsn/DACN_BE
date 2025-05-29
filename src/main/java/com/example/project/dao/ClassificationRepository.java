package com.example.project.dao;

import com.example.project.model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassificationRepository extends JpaRepository<Classification, Integer> {
   List <Classification> findByUserId(Integer userId);
}