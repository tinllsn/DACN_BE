package com.example.project.controller;

import com.example.project.dto.GuideDTO;
import com.example.project.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("guide")
public class GuideController {

    @Autowired
    private GuideService guideService;
    @GetMapping("/{title}")
    public ResponseEntity<List<GuideDTO>> getTitle(@PathVariable String title) {
        List<GuideDTO> guideList = guideService.getAllGuides(title);
        return new ResponseEntity<>(guideList, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<GuideDTO>> getAll() {
        List<GuideDTO> guideList = guideService.getAll();
        return new ResponseEntity<>(guideList, HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<GuideDTO> createGuide(@RequestBody  GuideDTO guideDTO) {
        GuideDTO createdGuide = guideService.createGuide(guideDTO);
        return new ResponseEntity<>(createdGuide, HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<GuideDTO> updateGuide(@RequestBody GuideDTO guideDTO) {
        GuideDTO updatedGuide = guideService.updateGuide(guideDTO);
        return new ResponseEntity<>(updatedGuide, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteGuide(@PathVariable Integer id) {
        String response = guideService.deleteGuide(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
