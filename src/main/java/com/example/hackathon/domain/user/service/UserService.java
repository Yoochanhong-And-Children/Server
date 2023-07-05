package com.example.hackathon.domain.user.service;

import com.example.hackathon.domain.user.User;
import com.example.hackathon.domain.user.controller.dto.request.SignUpRequest;
import com.example.hackathon.domain.user.controller.dto.request.UpdateRequest;
import com.example.hackathon.domain.user.controller.dto.response.UserInfoResponse;
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
    public void updateUser(Long id, UpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("찾을 수 없습니다."));

        user.update(request.getPhoneNumber(), request.getGuardianName(), request.getGuardianPhoneNumber());
    }

    @Transactional
    public UserInfoResponse findByPhoneNumber(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("찾을 수 없습니다."));

        return new UserInfoResponse(
                user.getId(),
                user.getPhoneNumber(),
                user.getGuardianName(),
                user.getGuardianPhoneNumber()
        );
    }
}
