package com.example.hackathon.domain.whether.controller;

import com.example.hackathon.domain.whether.service.WhetherMealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WhetherMealController {

    private final WhetherMealService whetherMealService;
}
