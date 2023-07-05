package com.example.hackathon.domain.user.controller.dto.response;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInfoResponse {
    private final Long id;
    private final String phoneNumber;
    private final String guardianName;
    private final String guardianPhoneNumber;
}
