//package com.example.project.controller;
//
//import com.example.project.dto.ImageDTO;
//import com.example.project.model.Image;
//import com.example.project.service.ImageService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Base64;
//
//@Controller
//@RequestMapping("image")
//public class ImageController {
//
//    @Autowired
//    private  ImageService imageService;
////    @Autowired
////    private ImageDTO dto;
//    @Autowired
//    private ModelMapper modelMapper;
//    @GetMapping("/{id}")
//    public ResponseEntity<ImageDTO> getImage(@PathVariable Integer userid) {
//       Image image =  imageService.getImage(userid);
//       try {
//           Path filepath = Paths.get(image.getUrlImage());
//           byte[] imageBytes = Files.readAllBytes(filepath);
//           // Convert to Base64
//           String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//            image.setUrlImage(base64Image);
//       } catch (Exception e) {
//           image.setUrlImage("");
//       }
//        ImageDTO dto = modelMapper.map(image, ImageDTO.class);
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }
//
//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<String> deleteImage(@PathVariable Integer id) {
//        if (imageService.deleteImage(id)){
//            return new ResponseEntity<>("Image deleted successfully", HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>("Image not found or could not be deleted", HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping("upload")
//    public  ResponseEntity<String> uploadImage(@RequestBody ImageDTO imageDTO) {
//        Image image = modelMapper.map(imageDTO, Image.class);
//        String response = imageService.createImage(image);
//        if (response != null) {
//            ImageDTO responseDto = modelMapper.map(image, ImageDTO.class);
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>("Failed to create image", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
//}
