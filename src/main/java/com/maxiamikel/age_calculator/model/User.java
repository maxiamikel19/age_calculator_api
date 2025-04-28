package com.maxiamikel.age_calculator.model;

import java.time.LocalDate;

import com.maxiamikel.age_calculator.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "userId")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "name")
    @NotBlank(message = "The name is required")
    private String name;

    @Column(name = "email")
    @NotBlank(message = "The email is required")
    @Email(message = "The email is invalid!")
    private String email;

    @Column(name = "burth_date")
    @NotBlank(message = "The burth date is required")
    private String burthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "created_at")
    private LocalDate createdAt;
}
