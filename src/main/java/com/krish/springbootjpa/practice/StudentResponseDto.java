package com.krish.springbootjpa.practice;

public record StudentResponseDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
