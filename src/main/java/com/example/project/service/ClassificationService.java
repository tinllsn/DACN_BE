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

    public ClassificationResponse save(Classification classification) {
        Classification cls= classificationRepository.save(classification);
        ClassificationResponse response = modelMapper.map(cls, ClassificationResponse.class);
        return response ;
    }


    public List<ClassificationResponse> getImage(ClassificationRequest request) {
        List<Classification> cl1 = classificationRepository.findByUserId(request.getUserId());
        return cl1.stream()
                .map(classification -> modelMapper.map(classification, ClassificationResponse.class))
                .collect(Collectors.toList());
    }

    public boolean deleteItem(Integer id) {
        if (classificationRepository.existsById(id)) {
            classificationRepository.deleteById(id);
            return !classificationRepository.existsById(id);
        } else {
            return false;
        }
    }
}


