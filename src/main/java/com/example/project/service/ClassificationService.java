package com.example.project.service;

import com.example.project.dao.ClassificationRepository;
import com.example.project.dao.UserRepository;
import com.example.project.dto.ClassificationRequest;
import com.example.project.dto.ClassificationResponse;
import com.example.project.model.Classification;
import com.example.project.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Classification save(Classification classification) {
        return classificationRepository.save(classification);
    }


    public ClassificationResponse createClassification(ClassificationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Classification classification = modelMapper.map(request, Classification.class);
        classification.setUserId(user.getId());

        Classification savedClassification = classificationRepository.save(classification);
        return modelMapper.map(savedClassification, ClassificationResponse.class);
    }

    public List<ClassificationResponse> getClassificationsByUserId(int userId) {
        List<Classification> classifications = classificationRepository.findByUserId(userId);
        return classifications.stream()
                .map(classification -> modelMapper.map(classification, ClassificationResponse.class))
                .collect(Collectors.toList());
    }
}