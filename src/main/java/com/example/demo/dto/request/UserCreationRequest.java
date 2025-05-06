package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 2, max = 50, message = "USER_NOT_VALID")
    String name;

    @Size(min = 8, message = "PASSWORD_NOT_VALID")
    String password;

    @Email(message = "EMAIL_NOT_VALID")
    String email;
    @NotNull(message = "DOB_NOT_NULL")
    LocalDate dob;
}
