package com.example.project.dao;

import com.example.project.model.Guide;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GuideRepository extends JpaRepository<Guide, Integer> {

    List<Guide> findAllBytitle(String title);
}
