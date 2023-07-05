package com.example.hackathon.domain.user.controller.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponse {
    private final String phoneNumber;
    private final String guardianName;
    private final String guardianPhoneNumber;
}
