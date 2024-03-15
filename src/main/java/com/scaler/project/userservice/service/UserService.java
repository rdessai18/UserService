package com.scaler.project.userservice.service;

import com.scaler.project.userservice.dto.LogoutDto;
import com.scaler.project.userservice.dto.SignUpDto;
import com.scaler.project.userservice.models.User;
import com.scaler.project.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(SignUpDto signUpDto) {
        User user = new User();
        user.setEmail(signUpDto.getEmail());
        user.setName(signUpDto.getName());
        String plainPassword = signUpDto.getPassword();
        String securePassword = getHashedPassword(plainPassword);
        user.setHashedPassword(securePassword);
        user = userRepository.save(user);
        return user;
    }

    private String getHashedPassword(String plainPassword) {
        // Using bcrypt password encoder
        //return passwordEncoder.encode(plainPassword);
        return plainPassword;
    }

    public void logOut(LogoutDto logoutDto) {

    }

    public User getUserByEmail(String userName) {
        Optional<User> userOptional = userRepository.findByEmail(userName);
        if (userOptional.isEmpty()){
            // exception
        }
        return userOptional.get();
    }
}
