package com.krish.springbootjpa.practice.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.createSchool(schoolDto);
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAllSchools() {
        return schoolService.findAllSchools();
    }

    @GetMapping("/schools/{school-id}")
    public School findSchoolById(@PathVariable("school-id") Integer id) {
        return schoolService.findSchoolById(id);
    }
}
