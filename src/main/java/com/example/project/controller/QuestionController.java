package com.example.project.controller;

import com.example.project.dto.QuestionDTO;
import com.example.project.model.Question;
import com.example.project.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private ModelMapper modelMapper;
    private static final String UPLOAD_DIR = "uploads/questions";

    @Autowired
    QuestionService questionService;
    @GetMapping("/allquestion")
    public ResponseEntity< List<Map<String, Object>>> getAllQuestion() {
        List<QuestionDTO> q  = questionService.getAllQuestion();
        List<Map<String, Object>> result = q.stream().map(item->
        {
            Map<String, Object> res = new HashMap<>();
            res.put("id", item.getId());
            res.put("question", item.getTitle());
            res.put("answer", item.getRightAnswer());

            try {
                Path filepath = Paths.get(item.getUrlImage());
                byte[] imageBytes = Files.readAllBytes(filepath);
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                res.put("image", base64Image);
            } catch (Exception e){
                res.put("image", "Error reading image: " + e.getMessage());
            }
            return res;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable Integer id) {
        Optional<Question> question = questionService.getQuestionById(id);
        if (question.isPresent()) {
            return new ResponseEntity<>(modelMapper.map(question.get(), QuestionDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(
            @RequestParam("file") MultipartFile file,
            @RequestParam("id") Integer id,
            @RequestParam("question") String questionText,
            @RequestParam("answer") Integer answer
    ) {
        try {
            // Tạo thư mục nếu chưa tồn tại
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();

            // Tạo tên file duy nhất
            String filename = System.currentTimeMillis() + "_" + StringUtils.cleanPath(file.getOriginalFilename());
            Path filepath = Paths.get(UPLOAD_DIR, filename);

            // Lưu ảnh vào thư mục
            Files.copy(file.getInputStream(), filepath, StandardCopyOption.REPLACE_EXISTING);

            // Tạo đối tượng Question (bạn cần có class Question phù hợp)
            Question question = new Question();
            question.setId(id);
            question.setTitle(questionText);
            question.setRightAnswer(answer);
            question.setUrlImage(filepath.toString()); // giả sử có trường imagePath trong entity

            // Gọi service lưu vào DB
            questionService.addQuestion(question);

            return ResponseEntity.ok("Thêm câu hỏi thành công");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi: " + e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateQuestion(
            @PathVariable("id") Integer id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("question") String questionText,
            @RequestParam("answer") Integer answer
    ) {
        try {
            // Tìm câu hỏi cũ
            Optional<Question> optional = questionService.getQuestionById(id);
            if (optional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Câu hỏi không tồn tại");
            }

            Question question = optional.get();
            question.setTitle(questionText);
            question.setRightAnswer(answer);

            // Nếu có ảnh mới thì cập nhật
            if (file != null && !file.isEmpty()) {
                String filename = System.currentTimeMillis() + "_" + StringUtils.cleanPath(file.getOriginalFilename());
                Path filepath = Paths.get(UPLOAD_DIR, filename);
                Files.copy(file.getInputStream(), filepath, StandardCopyOption.REPLACE_EXISTING);
                question.setUrlImage(filepath.toString());
            }

            questionService.addQuestion(question);  // dùng lại hàm save
            return ResponseEntity.ok("Cập nhật thành công");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi: " + e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("id") Integer id) {
        try {
            boolean deleted = questionService.deleteQuestionById(id);
            if (deleted) {
                return ResponseEntity.ok("Xoá thành công");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy câu hỏi với ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi: " + e.getMessage());
        }
    }


}
