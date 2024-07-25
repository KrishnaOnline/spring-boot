package com.krish.springbootjpa.practice.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "firstname is required, should not be empty")
        String firstName,
        // @NotEmpty
        @NotBlank
        String lastName,
        @Email
        String email,
        Integer schoolId
) {
}
