package com.example.hackathon.domain.whether.controller.dto;

import com.example.hackathon.domain.whether.enums.MealType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WhetherMealRequest {
    private MealType mealType;
}
