package com.example.hackathon.domain.user.service;

import com.example.hackathon.domain.user.User;
import com.example.hackathon.domain.user.controller.dto.SignUpRequest;
import com.example.hackathon.domain.user.controller.dto.UpdateRequest;
import com.example.hackathon.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void signup(SignUpRequest request) {
        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new RuntimeException("전화번호가 중복입니다.");
        }

        User user = User.builder()
                .guardianName(request.getGuardianName())
                .guardianPhoneNumber(request.getGuardianPhoneNumber())
                .deviceToken(request.getDeviceToken())
                .build();
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(String phoneNumber, UpdateRequest request) {
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("전화번호가 중복입니다."));


    }

}
