package com.example.hackathon.domain.user.service;

import com.example.hackathon.domain.user.User;
import com.example.hackathon.domain.user.controller.dto.request.SignUpRequest;
import com.example.hackathon.domain.user.controller.dto.request.UpdateRequest;
import com.example.hackathon.domain.user.controller.dto.response.UserInfoResponse;
import com.example.hackathon.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserInfoResponse signup(SignUpRequest request) {
        if (userRepository.existsByName(request.getName())) {
            throw new RuntimeException("전화번호가 중복입니다.");
        }

        User user = userRepository.save(
                User.builder()
                        .name(request.getName())
                        .guardianName(request.getGuardianName())
                        .guardianPhoneNumber(request.getGuardianPhoneNumber())
                        .deviceToken(request.getDeviceToken())
                        .build()
        );

        return UserInfoResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .guardianName(user.getGuardianName())
                .guardianPhoneNumber(user.getGuardianPhoneNumber())
                .build();
    }

    @Transactional
    public void updateUser(Long id, UpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("찾을 수 없습니다."));

        user.update(request.getName(), request.getGuardianName(), request.getGuardianPhoneNumber());
    }

    public UserInfoResponse getUserInfo(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("찾을 수 없습니다."));

        return UserInfoResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .guardianName(user.getGuardianName())
                .guardianPhoneNumber(user.getGuardianPhoneNumber())
                .build();
    }
}
