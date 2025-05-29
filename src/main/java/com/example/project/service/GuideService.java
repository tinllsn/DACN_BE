package com.example.project.service;

import com.example.project.dao.GuideRepository;
import com.example.project.dto.GuideDTO;
import com.example.project.model.Guide;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideService {

    @Autowired
    private GuideRepository guideRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<GuideDTO> getAllGuides(String title) {
        List<Guide> list = guideRepository.findAllBytitle(title);
        return list.stream()
                .map(guide -> modelMapper.map(guide, GuideDTO.class))
                .toList();
    }
    public GuideDTO createGuide(GuideDTO guideDTO) {
        if (guideDTO.getId() != null && guideRepository.existsById(guideDTO.getId())) {
            throw new IllegalArgumentException("Guide with this ID already exists");
        }
        Guide guide = modelMapper.map(guideDTO, Guide.class);
        Guide savedGuide = guideRepository.save(guide);
        return modelMapper.map(savedGuide, GuideDTO.class);
    }

    public GuideDTO updateGuide(GuideDTO guideDTO) {
        if (guideDTO.getId() == null || !guideRepository.existsById(guideDTO.getId())) {
            throw new EntityNotFoundException("Guide not found with ID: " + guideDTO.getId());
        }
        Guide guide = modelMapper.map(guideDTO, Guide.class);
        Guide savedGuide = guideRepository.save(guide);
        return modelMapper.map(savedGuide, GuideDTO.class);
    }

    public String deleteGuide(Integer id) {
        if (!guideRepository.existsById(id)) {
            return "Guide not found, cannot delete";
        }
        guideRepository.deleteById(id);
        return "Guide deleted successfully";
    }

    public List<GuideDTO> getAll() {
        List<Guide> list = guideRepository.findAll();

        return list.stream().map(item-> modelMapper.map(item,GuideDTO.class)).toList();
    }
}
