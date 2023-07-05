package com.example.hackathon.domain.whether.repository;

import com.example.hackathon.domain.whether.WhetherMeal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhetherMealRepository extends CrudRepository<WhetherMeal, Long> {
}
