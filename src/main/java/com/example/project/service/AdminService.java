package com.example.project.service;

import com.example.project.dao.AdminRepository;
import com.example.project.dao.UserRepository;
import com.example.project.dto.AdminDTO;
import com.example.project.dto.AuthRequest;
import com.example.project.dto.UserResponse;
import com.example.project.model.Admin;
import com.example.project.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ModelMapper modelMapper;


    public AdminDTO registerUser(AdminDTO request){
        if(adminRepository.findByUserName(request.getUsername()).isPresent()){
            return null;
        }

        String encodPass = bCryptPasswordEncoder.encode(request.getPassword());

        Admin newUser = modelMapper.map(request, Admin.class);
        newUser.setId(null);
        newUser.setPassWord(encodPass);
        adminRepository.save(newUser);


        return modelMapper.map(newUser, AdminDTO.class);
    }

    public UserResponse loginuser(AdminDTO request){
        Admin user = adminRepository.findByUserName(request.getUsername()).orElseThrow(()-> new RuntimeException("User not found"));
//        Admin user =  adminRepository.findByUserName(request.getUsername());
        if (bCryptPasswordEncoder.matches(request.getPassword(),user.getPassWord())){
            return modelMapper.map(user,UserResponse.class);

        } else {
            return null;
        }
    }

    public UserResponse getUserById(Integer id) {
        Optional<Admin> userOptional = adminRepository.findById(id);
        if (userOptional.isPresent()) {
            return modelMapper.map(userOptional.get(), UserResponse.class);
        } else {
            return null;
        }
    }

    public  boolean deleteUser(Integer id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return !adminRepository.existsById(id); // Check if the entity still exists
        } else {
            return false; // Entity does not exist
        }

    }

    public String updateUser(UserResponse request) {
        Optional<Admin> user =   adminRepository.findById(request.getId());
        if(user.isPresent()){
            Admin existingUser = user.get();
            existingUser.setUserName(request.getUsername());
            existingUser.setPassWord(bCryptPasswordEncoder.encode(request.getPassword()));
            existingUser.setEmail(request.getEmail());

            adminRepository.save(existingUser);
        } else {
            return "User not found";
        }

        return "Success";
    }

    public List<UserResponse> getAllUsers() {
        List<Admin> users = adminRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .toList();
    }
}
