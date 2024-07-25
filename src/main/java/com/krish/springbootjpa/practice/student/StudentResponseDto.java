package com.krish.springbootjpa.practice.student;

public record StudentResponseDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
