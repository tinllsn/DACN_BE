//package com.example.project.service;
//
//import com.example.project.dao.ClassificationRepository;
//import com.example.project.dao.FeedbackRepository;
//import com.example.project.dto.FeedbackRequest;
//import com.example.project.dto.FeedbackResponse;
//import com.example.project.model.Classification;
//import com.example.project.model.Feedback;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class FeedbackService {
//
//    @Autowired
//    private FeedbackRepository feedbackRepository;
//
//    @Autowired
//    private ClassificationRepository classificationRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public FeedbackResponse createFeedback(FeedbackRequest request) {
//        Classification classification = classificationRepository.findById(request.getClassificationId())
//                .orElseThrow(() -> new RuntimeException("Classification not found"));
//
//        Feedback feedback = modelMapper.map(request, Feedback.class);
//        feedback.setClassification(classification);
//
//        Feedback savedFeedback = feedbackRepository.save(feedback);
//        return modelMapper.map(savedFeedback, FeedbackResponse.class);
//    }
//
//    public List<FeedbackResponse> getFeedbacksByClassificationId(int classificationId) {
//        List<Feedback> feedbacks = feedbackRepository.findByClassificationId(classificationId);
//        return feedbacks.stream()
//                .map(feedback -> modelMapper.map(feedback, FeedbackResponse.class))
//                .collect(Collectors.toList());
//    }
//}package com.example.project.dao;
//
//import com.example.project.model.Feedback;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//@Repository
//public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
//    List<Feedback> findByClassificationId(int classificationId);
//}