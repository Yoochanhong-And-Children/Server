package com.example.hackathon.domain.user;

import com.example.hackathon.domain.whether.WhetherMeal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "tbl_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "char(5)")
    private String name;

    @NotNull
    @Column(columnDefinition = "char(5)")
    private String guardianName;

    @NotNull
    @Column(columnDefinition = "char(11)")
    private String guardianPhoneNumber;

    @NotNull
    @Column(columnDefinition = "char(255) default ''")
    private String deviceToken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WhetherMeal> whetherMeals;

    public void update(String name, String guardianName, String guardianPhoneNumber) {
        this.name = name;
        this.guardianName = guardianName;
        this.guardianPhoneNumber = guardianPhoneNumber;
    }
}
