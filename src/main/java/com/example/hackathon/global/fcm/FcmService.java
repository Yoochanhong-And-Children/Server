package com.example.hackathon.global.fcm;

import com.google.api.core.ApiFuture;
import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

@Service
public class FcmService {

    public void sendNotification(String title, String body, String token) {
        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build()
                )
                .setToken(token)
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setSound("default")
                                .build()
                        )
                        .build())
                .build();

        ApiFuture<String> stringApiFuture = FirebaseMessaging.getInstance().sendAsync(message);
        if (stringApiFuture.isDone() == Boolean.FALSE) {
            throw new IllegalArgumentException("푸시 알림 전송에 실패하였습니다.");
        }
    }
}
