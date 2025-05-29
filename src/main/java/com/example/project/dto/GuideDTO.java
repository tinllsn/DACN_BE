package com.example.project.dto;

import lombok.Data;

@Data
public class GuideDTO {
    private Integer id;
    private String title;
    private String content;
    private Boolean allowed; // true: cho phép, false: không cho phép
}
