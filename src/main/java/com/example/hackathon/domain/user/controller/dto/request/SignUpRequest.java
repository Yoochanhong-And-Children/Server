package com.example.hackathon.domain.user.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Size(max = 5, message = "5자 까지 입력 가능합니다")
    private String name;

    @NotBlank
    @Size(max = 5, message = "5자 까지 입력 가능합니다")
    private String guardianName;

    @NotBlank
    @Size(max = 11, message = "11자 까지 입력 가능합니다")
    private String guardianPhoneNumber;

    @NotBlank
    private String deviceToken;

}
