//package com.example.project.model;
//
//import jakarta.persistence.Embeddable;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class UserBadgeId implements Serializable {
//
//    private int userId;
//    private int badgeId;
//
//    public UserBadgeId() {}
//
//    public UserBadgeId(int userId, int badgeId) {
//        this.userId = userId;
//        this.badgeId = badgeId;
//    }
//
//    // Getters, Setters, equals, and hashCode
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserBadgeId that = (UserBadgeId) o;
//        return userId == that.userId && badgeId == that.badgeId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userId, badgeId);
//    }
//}