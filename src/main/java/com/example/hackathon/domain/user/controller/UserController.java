package com.example.hackathon.domain.user.controller;

import com.example.hackathon.domain.user.controller.dto.SignUpRequest;
import com.example.hackathon.domain.user.controller.dto.UpdateRequest;
import com.example.hackathon.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signup(@Valid @RequestBody SignUpRequest request) {
        userService.signup(request);
    }


    @PatchMapping("/{phoneNumber}")
    public void update(@PathVariable String phoneNumber, @RequestBody @Valid UpdateRequest request) {
        userService.updateUser(phoneNumber, request);
    }
}
