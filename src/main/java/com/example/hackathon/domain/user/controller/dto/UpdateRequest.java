package com.example.hackathon.domain.user.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRequest {

    @NotBlank
    @Size(max = 11, message = "11자 까지 입력 가능합니다")
    private String phoneNumber;

    @NotBlank
    @Size(max = 5, message = "5자 까지 입력 가능합니다")
    private String guardianName;

    @NotBlank
    @Size(max = 11, message = "11자 까지 입력 가능합니다")
    private String guardianPhoneNumber;
}
