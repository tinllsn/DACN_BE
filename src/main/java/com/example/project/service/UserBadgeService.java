//package com.example.project.service;
//
//import com.example.project.dao.BadgeRepository;
//import com.example.project.dao.UserBadgeRepository;
//import com.example.project.dao.UserRepository;
//import com.example.project.dto.UserBadgeRequest;
//import com.example.project.dto.UserBadgeResponse;
//import com.example.project.model.Badge;
//import com.example.project.model.User;
//import com.example.project.model.UserBadge;
//import com.example.project.model.UserBadgeId;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserBadgeService {
//
//    @Autowired
//    private UserBadgeRepository userBadgeRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BadgeRepository badgeRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public UserBadgeResponse assignBadgeToUser(UserBadgeRequest request) {
//        User user = userRepository.findById(request.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Badge badge = badgeRepository.findById(request.getBadgeId())
//                .orElseThrow(() -> new RuntimeException("Badge not found"));
//
//        UserBadgeId id = new UserBadgeId(request.getUserId(), request.getBadgeId());
//        if (userBadgeRepository.existsById(id)) {
//            throw new RuntimeException("Badge already assigned to user");
//        }
//
//        UserBadge userBadge = new UserBadge();
//        userBadge.setId(id);
//        userBadge.setUser(user);
//        userBadge.setBadge(badge);
//
//        UserBadge savedUserBadge = userBadgeRepository.save(userBadge);
//        return modelMapper.map(savedUserBadge, UserBadgeResponse.class);
//    }
//
//    public List<UserBadgeResponse> getBadgesByUserId(int userId) {
//        List<UserBadge> userBadges = userBadgeRepository.findByUserId(userId);
//        return userBadges.stream()
//                .map(userBadge -> modelMapper.map(userBadge, UserBadgeResponse.class))
//                .collect(Collectors.toList());
//    }
//}