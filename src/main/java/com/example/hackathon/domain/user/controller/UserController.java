package com.example.hackathon.domain.user.controller;

import com.example.hackathon.domain.user.controller.dto.request.SignUpRequest;
import com.example.hackathon.domain.user.controller.dto.request.UpdateRequest;
import com.example.hackathon.domain.user.controller.dto.response.UserInfoResponse;
import com.example.hackathon.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public UserInfoResponse signup(@Valid @RequestBody SignUpRequest request) {
        return userService.signup(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id, @Valid @RequestBody UpdateRequest request) {
        userService.updateUser(id, request);
    }

    @GetMapping("/{id}")
    public UserInfoResponse getUserInfo(@PathVariable Long id) {
        return userService.getUserInfo(id);
    }
}
