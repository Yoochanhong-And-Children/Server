package com.example.hackathon.domain.notification.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NotificationRequest {
    private String deviceToken;
    private String name;
}
