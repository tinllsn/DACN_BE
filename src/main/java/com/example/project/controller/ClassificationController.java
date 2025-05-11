package com.example.project.controller;

import com.example.project.dto.ClassificationRequest;
import com.example.project.dto.ClassificationResponse;
import com.example.project.model.Classification;
import com.example.project.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//mport com.example.project.model.Classification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.*;
import java.util.List;


import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("classifications")
public class ClassificationController {

    private static final String UPLOAD_DIR = "uploads/";
    @Autowired
    private ClassificationService classificationService;

    @PostMapping("uploads")
    public ResponseEntity<?> handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userId") Integer userId,
            @RequestParam("wasteType") String wasteType,
            @RequestParam("confidence") Float confidence,
            @RequestParam("suggestion") String suggestion
    ) {
        try {
            // Tạo thư mục nếu chưa tồn tại
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();

            // Tạo đường dẫn và lưu ảnh
            String filename = System.currentTimeMillis() + "_" + StringUtils.cleanPath(file.getOriginalFilename());
            Path filepath = Paths.get(UPLOAD_DIR, filename);
            Files.copy(file.getInputStream(), filepath, StandardCopyOption.REPLACE_EXISTING);
// Gọi flask
            // Gửi ảnh đến model AI (Flask)
            RestTemplate restTemplate = new RestTemplate();
//            http://127.0.0.1:5000/detect
            String modelApiUrl = "http://127.0.0.1:5000/predict";
            String absolutePath = new File(UPLOAD_DIR, filename).getAbsolutePath();
            Map<String, String> payload = new HashMap<>();
            payload.put("imagePath", absolutePath);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);

            ResponseEntity<Map> response = restTemplate.postForEntity(modelApiUrl, request, Map.class);

// Xử lý kết quả từ AI
//            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
//                List<Map<String, Object>> preds = (List<Map<String, Object>>) response.getBody().get("predictions");
//                if (!preds.isEmpty()) {
//                    Map<String, Object> pred = preds.get(0); // lấy kết quả đầu tiên
//                    wasteType = (String) pred.get("wasteType");
//                    confidence = ((Number) pred.get("confidence")).floatValue();
//                }
//            }

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                List<Map<String, Object>> preds = (List<Map<String, Object>>) response.getBody().get("predictions");
                if (!preds.isEmpty()) {
                    // Tìm prediction có confidence lớn nhất
                    Map<String, Object> bestPred = preds.stream()
                            .max((a, b) -> Float.compare(
                                    ((Number) a.get("confidence")).floatValue(),
                                    ((Number) b.get("confidence")).floatValue()
                            ))
                            .orElse(preds.get(0));

                    String rawType = ((String) bestPred.get("wasteType")).toLowerCase();
                    confidence = ((Number) bestPred.get("confidence")).floatValue();

                    // Phân nhóm rác dựa vào loại
                    if (List.of("metal", "plastic", "cardboard").contains(rawType)) {
                        wasteType = "Recyclable";
                    } else if (List.of("paper", "random trash", "glass").contains(rawType)) {
                        wasteType = "Inorganic";
                    } else if ("organics".equals(rawType)) {
                        wasteType = "Organic";
                    } else {
                        wasteType = "Unknown";
                    }
                }
            }


//
            // Tạo đối tượng Classification
            Classification classification = new Classification();
            classification.setUserId(userId);
            classification.setImageUrl(filepath.toString());
            classification.setWasteType(wasteType);
            classification.setConfidence(confidence);
            classification.setSuggestion(suggestion);

            // Lưu vào DB
            Classification saved = classificationService.save(classification);
            return ResponseEntity.ok(saved);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Upload failed: " + e.getMessage());
        }

    }
}

//    public ResponseEntity<ClassificationResponse> createClassification(@RequestBody ClassificationRequest request) {
//        ClassificationResponse response = classificationService.createClassification(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

//    @GetMapping("user/{userId}")
//    public ResponseEntity<List<ClassificationResponse>> getClassificationsByUserId(@PathVariable int userId) {
//        List<ClassificationResponse> responses = classificationService.getClassificationsByUserId(userId);
//        return new ResponseEntity<>(responses, HttpStatus.OK);
//    }