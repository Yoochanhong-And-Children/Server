package com.example.hackathon.domain.notification.service;

import com.example.hackathon.domain.user.User;
import com.example.hackathon.domain.user.repository.UserRepository;
import com.example.hackathon.global.fcm.FcmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationService {

    private final FcmService fcmService;
    private final UserRepository userRepository;

    public void sendNotification(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        fcmService.sendNotification("테스트", "테스트", user.getDeviceToken());
    }
}
