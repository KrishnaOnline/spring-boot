package com.krish.springbootjpa.practice;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
