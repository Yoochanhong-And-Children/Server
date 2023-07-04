package com.example.hackathon.global.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SmsService {

    @Value("${twilio.account.sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth.token}")
    private String AUTH_TOKEN;

    @Value("${twilio.phone.number}")
    private String TWILIO_PHONE_NUMBER;

    @PostConstruct
    private void initTwilio() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendSms(String toPhoneNumber, String messageContent) {
        createMessage(toPhoneNumber, TWILIO_PHONE_NUMBER, messageContent);
    }

    private void createMessage(String toPhoneNumber, String fromPhoneNumber, String content) {
        Message.creator(
                new PhoneNumber(toPhoneNumber), new PhoneNumber(fromPhoneNumber), content
        ).create();
    }
}
