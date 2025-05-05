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