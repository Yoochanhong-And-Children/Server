package com.example.hackathon.domain.letter.service;

import com.example.hackathon.domain.letter.Letter;
import com.example.hackathon.domain.letter.controller.dto.LetterResponse;
import com.example.hackathon.domain.letter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LetterService {

    private final LetterRepository letterRepository;

    public LetterResponse getLetter() {
        Letter letter = letterRepository.findRandom()
                .orElseThrow(() -> new RuntimeException("찾을 수 없습니다."));

        return new LetterResponse(letter.getLetter());
    }
}
