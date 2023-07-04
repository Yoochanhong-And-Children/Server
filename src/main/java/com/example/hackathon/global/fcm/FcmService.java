package com.example.hackathon.global.fcm;

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

        try {
            FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("푸시 알림을 보내는데 실패했습니다.", e);
        }
    }
}
