package com.example.hackathon.domain.whether.service;

import com.example.hackathon.domain.user.User;
import com.example.hackathon.domain.user.repository.UserRepository;
import com.example.hackathon.domain.whether.WhetherMeal;
import com.example.hackathon.domain.whether.enums.MealType;
import com.example.hackathon.domain.whether.repository.WhetherMealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class WhetherMealService {

    private final UserRepository userRepository;
    private final WhetherMealRepository whetherMealRepository;

    public void saveWhetherMeal(Long id, MealType mealType) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저가 존재하지 않습니다"));

        WhetherMeal whetherMeal = WhetherMeal.builder()
                .user(user)
                .date(LocalDate.now())
                .mealType(mealType)
                .build();
        whetherMealRepository.save(whetherMeal);
    }
}
