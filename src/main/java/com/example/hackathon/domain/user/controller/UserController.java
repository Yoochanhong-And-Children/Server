package com.example.hackathon.domain.user.controller;

import com.example.hackathon.domain.user.controller.dto.request.SignUpRequest;
import com.example.hackathon.domain.user.controller.dto.request.UpdateRequest;
import com.example.hackathon.domain.user.controller.dto.response.UserInfoResponse;
import com.example.hackathon.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signup(@Valid @RequestBody SignUpRequest request) {
        userService.signup(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{phoneNumber}")
    public void update(@PathVariable("phoneNumber") String phoneNumber, @Valid @RequestBody UpdateRequest request) {
        userService.updateUser(phoneNumber, request);
    }

    @GetMapping("/{phoneNumber}")
    public UserInfoResponse findByPhoneNumber(@PathVariable String phoneNumber) {
        return userService.findByPhoneNumber(phoneNumber);
    }
}
