package com.krish.springbootjpa.practice;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        var school = toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    private School toSchool(SchoolDto schoolDto) {
        return new School(
                schoolDto.name()
        );
    }

//    private SchoolResponseDto toSchoolResponse(School school) {
//        return new SchoolResponseDto(
//                school.getName()
//        );
//    }

    private SchoolDto toSchoolResponse(School school) {
        return new SchoolDto(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAllSchools() {
        return schoolRepository.findAll()
                .stream().map(this::toSchoolResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/schools/{school-id}")
    public School findSchoolById(@PathVariable("school-id") Integer id) {
        return schoolRepository.findById(id).orElse(new School());
    }
}
