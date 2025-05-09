package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactCreationRequest {
    @Email(message = "EMAIL_NOT_VALID")
    String email;
    @Size(min = 10, max = 15, message = "PHONE_NOT_VALID")
    String phone;
    String name;
    String notes;
    String address;
    String userId;
}
