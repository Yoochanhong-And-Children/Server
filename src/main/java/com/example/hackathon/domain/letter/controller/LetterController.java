package com.example.hackathon.domain.letter.controller;

import com.example.hackathon.domain.letter.controller.dto.LetterResponse;
import com.example.hackathon.domain.letter.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LetterController {

    private final LetterService letterService;

    @GetMapping("/letter")
    public LetterResponse getLetter() {
        return letterService.getLetter();
    }
}
