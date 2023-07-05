package com.example.hackathon.domain.user.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class UserCheckResponse {
    private String name;
    private String guardianName;
    private String guardianPhoneNumber;
}
