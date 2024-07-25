package com.krish.springbootjpa.practice.student;

import org.springframework.stereotype.Service;

import com.krish.springbootjpa.practice.school.School;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto studentDto) {
        var student = new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());
        var school = new School();
        school.setId(studentDto.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDto toStudentResponse(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getSchool().getId()
        );
    }
}
