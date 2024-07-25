package com.krish.springbootjpa.practice.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto schoolDto) {
        return new School(schoolDto.name());
    }

    public SchoolDto toSchoolResponse(School school) {
        return new SchoolDto(school.getName());
    }
}
