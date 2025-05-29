package com.example.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClassificationRequest {
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("iamgeUrl")
    private String imageUrl;
    @JsonProperty("wasteType")
    private String wasteType;
    private Float confidence;
    @JsonProperty("suggestion")
    private String suggestion;
}