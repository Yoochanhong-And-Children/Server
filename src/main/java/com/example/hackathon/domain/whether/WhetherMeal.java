package com.example.hackathon.domain.whether;

import com.example.hackathon.domain.user.User;
import com.example.hackathon.domain.whether.enums.MealType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "tbl_whether_meal")
@Entity
public class WhetherMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate date = LocalDate.now();

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('BREAKFAST', 'LUNCH', 'DINNER')")
    private MealType mealType;
}
