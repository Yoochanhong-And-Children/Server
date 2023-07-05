package com.example.hackathon.domain.whether.service;

import com.example.hackathon.domain.whether.repository.WhetherMealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WhetherMealService {

    private final WhetherMealRepository whetherMealRepository;
}
