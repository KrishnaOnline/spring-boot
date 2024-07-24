package com.krish.springbootjpa.practice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public School createSchool(@RequestBody School school) {
        return schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    @GetMapping("/schools/{school-id}")
    public School findSchoolById(@PathVariable("school-id") Integer id) {
        return schoolRepository.findById(id).orElse(new School());
    }
}
