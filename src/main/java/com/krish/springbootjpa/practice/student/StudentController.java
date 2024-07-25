package com.krish.springbootjpa.practice.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
public class StudentController {
    // Constructor Injection (RECOMMENDED)
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto createStudent(
        @Valid @RequestBody StudentDto studentDto
    ) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents() {
        return this.studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto getStudentById(@PathVariable("student-id") Integer id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-email}")
    public List<StudentResponseDto> findStudentsByEmail(@PathVariable("student-email") String mail) {
        return studentService.findStudentsByEmail(mail);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable("student-id") Integer id) {
        this.studentService.deleteStudentById(id);
    }
}
