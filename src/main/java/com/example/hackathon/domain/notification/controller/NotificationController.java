package com.example.hackathon.domain.notification.controller;

import com.example.hackathon.domain.notification.controller.dto.request.NotificationRequest;
import com.example.hackathon.domain.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/notification")
    public void sendNotification(@RequestBody NotificationRequest request) {
        notificationService.sendNotification(request.getDeviceToken());
    }
}
