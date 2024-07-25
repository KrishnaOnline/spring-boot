package com.krish.springbootjpa.practice.school;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public SchoolDto createSchool(SchoolDto schoolDto) {
        var school = schoolMapper.toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    public List<SchoolDto> findAllSchools() {
        return schoolRepository.findAll()
                .stream().map(schoolMapper::toSchoolResponse)
                .collect(Collectors.toList());
    }

    public School findSchoolById(Integer id) {
        return schoolRepository.findById(id).orElse(new School());
    }
}
