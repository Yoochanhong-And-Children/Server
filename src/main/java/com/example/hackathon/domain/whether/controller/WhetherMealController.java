package com.example.hackathon.domain.whether.controller;

import com.example.hackathon.domain.whether.controller.dto.WhetherMealRequest;
import com.example.hackathon.domain.whether.service.WhetherMealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/whether")
@RestController
public class WhetherMealController {

    private final WhetherMealService whetherMealService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public void createWhetherMeal(@PathVariable("id") Long id, @Valid @RequestBody WhetherMealRequest request) {
        whetherMealService.saveWhetherMeal(id, request.getMealType());
    }
}
