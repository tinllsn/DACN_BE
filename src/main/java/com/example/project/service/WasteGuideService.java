//package com.example.project.service;
//
//import com.example.project.dao.WasteGuideRepository;
//import com.example.project.dto.WasteGuideRequest;
//import com.example.project.dto.WasteGuideResponse;
//import com.example.project.model.WasteGuide;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class WasteGuideService {
//
//    @Autowired
//    private WasteGuideRepository wasteGuideRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public WasteGuideResponse createWasteGuide(WasteGuideRequest request) {
//        if (wasteGuideRepository.findByWasteType(request.getWasteType()).isPresent()) {
//            throw new RuntimeException("Waste guide for this type already exists");
//        }
//
//        WasteGuide wasteGuide = modelMapper.map(request, WasteGuide.class);
//        WasteGuide savedWasteGuide = wasteGuideRepository.save(wasteGuide);
//        return modelMapper.map(savedWasteGuide, WasteGuideResponse.class);
//    }
//
//    public List<WasteGuideResponse> getAllWasteGuides() {
//        List<WasteGuide> wasteGuides = wasteGuideRepository.findAll();
//        return wasteGuides.stream()
//                .map(wasteGuide -> modelMapper.map(wasteGuide, WasteGuideResponse.class))
//                .collect(Collectors.toList());
//    }
//
//    public WasteGuideResponse getWasteGuideByType(String wasteType) {
//        WasteGuide wasteGuide = wasteGuideRepository.findByWasteType(wasteType)
//                .orElseThrow(() -> new RuntimeException("Waste guide not found for type: " + wasteType));
//        return modelMapper.map(wasteGuide, WasteGuideResponse.class);
//    }
//}