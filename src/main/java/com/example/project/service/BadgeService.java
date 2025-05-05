//package com.example.project.service;
//
//import com.example.project.dao.BadgeRepository;
//import com.example.project.dto.BadgeRequest;
//import com.example.project.dto.BadgeResponse;
//import com.example.project.model.Badge;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class BadgeService {
//
//    @Autowired
//    private BadgeRepository badgeRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public BadgeResponse createBadge(BadgeRequest request) {
//        if (badgeRepository.existsByName(request.getName())) {
//            throw new RuntimeException("Badge with the same name already exists");
//        }
//
//        Badge badge = modelMapper.map(request, Badge.class);
//        Badge savedBadge = badgeRepository.save(badge);
//        return modelMapper.map(savedBadge, BadgeResponse.class);
//    }
//
//    public List<BadgeResponse> getAllBadges() {
//        List<Badge> badges = badgeRepository.findAll();
//        return badges.stream()
//                .map(badge -> modelMapper.map(badge, BadgeResponse.class))
//                .collect(Collectors.toList());
//    }
//}