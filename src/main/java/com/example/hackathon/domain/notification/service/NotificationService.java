package com.example.hackathon.domain.notification.service;

import com.example.hackathon.global.fcm.FcmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationService {

    private final FcmService fcmService;

    public void sendNotification(String deviceToken, String name) {
        fcmService.sendNotification("알림", name + "님 아침 식사는 하셨나요?", deviceToken);
    }
}
