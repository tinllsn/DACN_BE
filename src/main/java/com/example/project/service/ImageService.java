//package com.example.project.service;
//
//import com.example.project.dao.ImageRepository;
//import com.example.project.model.Image;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ImageService {
//
//    @Autowired
//    private ImageRepository imageRepository;
//    public Image getImage(int id) {
//      Optional<Image> image = imageRepository.findById(id);
//        if (image.isPresent()) {
//            return image.get();
//        } else {
//            throw new RuntimeException("Image not found with id: " + id);
//        }
//    }
//
//    public boolean deleteImage(Integer id) {
//        if (imageRepository.existsById(id)){
//            imageRepository.deleteById(id);
//            return !imageRepository.existsById(id);
//        }
//        else {
//            return false;
//        }
//
//    }
//
//    public String createImage(Image image) {
//      Image im = imageRepository.save(image);
//      if (im!= null) {
//          return "Successfully created image with id: " + im.getId() + " and url: " + im.getUrlImage();
//
//    }else {
//      return  "";
//      }
//    }
////    public List<Image> getAllImagesByUserId(Integer userId) {
////        List<Image>
////        return imageRepository.findByUserId(userId);
////    }
//}
