package com.example.hackathon.domain.notification.service;

import com.example.hackathon.global.fcm.FcmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationService {

    private final FcmService fcmService;

    public void sendNotification(String deviceToken) {
        fcmService.sendNotification("테스트", "테스트", deviceToken);
    }
}
