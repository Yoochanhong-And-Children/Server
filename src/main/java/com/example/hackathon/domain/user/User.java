package com.example.hackathon.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
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

    public void update(String name, String guardianName, String guardianPhoneNumber) {
        this.name = name;
        this.guardianName = guardianName;
        this.guardianPhoneNumber = guardianPhoneNumber;
    }
}
