package com.example.project.controller;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class DetectionController {

    private final RestTemplate restTemplate;

    public DetectionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/detect")
    public ResponseEntity<Object> detectImage(@RequestParam("imagePath") String imagePath) {
        String flaskUrl = "http://127.0.0.1:5000/detect";

        // Thiết lập header cho multipart/form-data
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Tạo body dạng multipart
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("image_path", imagePath);

        // Tạo HttpEntity
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(flaskUrl, request, String.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error calling FastAPI: " + e.getMessage());
        }
    }
}